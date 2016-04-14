select a.*,
i_user_feedback.immagine_hash user_feedback_immagine_hash,
i_user_opera.immagine_hash user_opera_immagine_hash,
i_opera.immagine_hash opera_immagine_hash

from (
	select 

	feedback.feedback_id as feedback_id,
	feedback.feedback_voto as feedback_voto,
    feedback.feedback_descrizione as feedback_descrizione,
	feedback.feedback_id_opera as feedback_id_opera, 
	feedback.feedback_date as feedback_date,
    
	opere.opera_id,
	opere.opera_active,
	opere.opera_descrizione,
    opere.opera_id_immagine,
	 
	u_f.user_id as user_feedback_id,
	u_f.user_nome as user_feedback_nome,
	u_f.user_cognome as user_feedback_cognome,
    u_f.user_foto as user_feedback_foto,
    u_f.user_id_ruolo as user_feedback_id_ruolo,

	u_o.user_id as user_opera_id,
	u_o.user_nome as user_opera_nome,
	u_o.user_cognome as user_opera_cognome,
    u_o.user_foto as user_opera_foto,
    u_o.user_id_ruolo as user_opera_id_ruolo

	from 
    users u_f, 
    users u_o, 
    feedback, 
    opere 
	where 
		feedback.feedback_id_user = u_f.user_id and 
		feedback.feedback_id_opera = opere.opera_id and 
		opere.opera_id_user = u_o.user_id 
		
		$if(userOperaId)$
			and opere.opera_id_user = $userOperaId$ 
		$endif$
		
		$if(userFeedbackId)$
			and u_f.user_id = $userFeedbackId$ 
		$endif$
		
		$if(feedbackVoto)$
			and feedback.feedback_voto >= $feedbackVoto$
		$endif$
			 
		$if(feedbackDescrizione)$
			and feedback.feedback_descrizione like '%$feedbackDescrizione$%'
		$endif$
		
		$if(feedbackIdOpera)$
			and feedback.feedback_id_opera = $feedbackIdOpera$
		$endif$

		$if(feedbackDate)$
			and feedback.feedback_date = $feedbackDate$
		$endif$
		
		$if(operaActive)$
			and opere.opera_active = $operaActive$
		$endif$
		
		
		
		order by feedback.feedback_date
    
    ) a
    
	
left join immagini i_user_opera on a.user_opera_foto = i_user_opera.immagine_id
left join immagini i_opera on a.opera_id_immagine = i_opera.immagine_id
left join immagini i_user_feedback on a.user_feedback_foto = i_user_feedback.immagine_id 
