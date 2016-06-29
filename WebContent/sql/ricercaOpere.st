select opera_titolo,opera_descrizione, 
opera_titolo_eng,opera_descrizione_eng, 
opera_id,user_id,user_nome,
user_cognome,user_link,
immagine_id,
immagine_hash,
opera_insert,
opera_active,

website, youtube_link, twitter_link, facebook_link, google_link,

count(case when f.feedback_tipo=1 then f.feedback_id_opera else null end ) opera_rate_pop_feeds, 
avg(case when f.feedback_tipo=1 then f.feedback_voto else null end ) opera_pop_avg, 
sum(case when f.feedback_tipo=1 then f.feedback_voto else null end ) opera_rate_pop,

count(case when f.feedback_tipo=2 then f.feedback_id_opera else null end ) opera_rate_crit_feeds, 
avg(case when f.feedback_tipo=2 then f.feedback_voto else null end ) opera_crit_avg,  
sum(case when f.feedback_tipo=2 then f.feedback_voto else null end ) opera_rate_crit,
GROUP_CONCAT(distinct(t.tag_desc) SEPARATOR '#@#') tags

from  users u, immagini i,opere o
left join feedback f on f.feedback_id_opera = o.opera_id
left join tag t on t.tag_opera_id = o.opera_id 
where u.user_id = o.opera_id_user 
and i.immagine_id = o.opera_id_immagine 
and o.opera_active = 1
and u.user_active = 1
and ( true=true

$if(operaNome)$
	and o.opera_titolo like '%$operaNome$%' 
$endif$	

$if(operaDescrizione)$
	and o.opera_descrizione like '%$operaDescrizione$%' 
$endif$	

$if(operaNomeEng)$
	and o.opera_titolo_eng like '%$operaNomeEng$%' 
$endif$	

$if(operaDescrizioneEng)$
	and o.opera_descrizione_eng like '%$operaDescrizioneEng$%' 
$endif$	

$if(nome)$
	and u.user_nome like '%$nome$%' 
$endif$	

$if(cognome)$
	and u.user_cognome like '%$cognome$%' 
$endif$	

$if(nazione)$
	and u.user_nazione like '%$nazione$%' 
$endif$	

$if(citta)$
	and u.user_citta like '%$citta$%' 
$endif$	

$if(tag)$
	and t.tag_desc like '%$tag$%' 
$endif$	
)

group by (opera_titolo)