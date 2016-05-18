select opera_titolo,opera_descrizione, opera_id,user_id,user_nome,
user_cognome,user_link,immagine_id,immagine_hash,opera_insert,opera_active,
count(f1.feedback_id_opera) opera_rate_pop_feeds, avg(f1.feedback_voto), sum(f1.feedback_voto) opera_rate_pop,
count(f2.feedback_id_opera) opera_rate_crit_feeds, avg(f2.feedback_voto), sum(f2.feedback_voto) opera_rate_crit
from  users u, immagini i, opere o
left join feedback f1 on (f1.feedback_id_opera = o.opera_id and  f1.feedback_tipo=1)
left join feedback f2 on (f2.feedback_id_opera = o.opera_id and  f2.feedback_tipo=2)
where u.user_id = o.opera_id_user 
and i.immagine_id = o.opera_id_immagine 
$if(ricerca)$
	and (o.opera_titolo like '%$ricerca$%' or o.opera_descrizione like '%$ricerca$%')
$endif$
group by (opera_titolo)