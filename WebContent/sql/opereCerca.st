select opera_titolo,opera_descrizione, 
opera_titolo_eng,opera_descrizione_eng, 
opera_id,user_id,user_nome,
user_cognome,user_link,
immagine_id,
immagine_hash,
opera_insert,
opera_active,

count(case when f.feedback_tipo=1 then f.feedback_id_opera else null end ) opera_rate_pop_feeds, 
avg(case when f.feedback_tipo=1 then f.feedback_voto else null end ) opera_pop_avg, 
sum(case when f.feedback_tipo=1 then f.feedback_voto else null end ) opera_rate_pop,

count(case when f.feedback_tipo=2 then f.feedback_id_opera else null end ) opera_rate_crit_feeds, 
avg(case when f.feedback_tipo=2 then f.feedback_voto else null end ) opera_crit_avg,  
sum(case when f.feedback_tipo=2 then f.feedback_voto else null end ) opera_rate_crit


from  users u, immagini i, opere o 
left join feedback f on f.feedback_id_opera = o.opera_id
where u.user_id = o.opera_id_user 
and i.immagine_id = o.opera_id_immagine
$if(ricerca)$
	and (o.opera_titolo like '%$ricerca$%' or o.opera_descrizione like '%$ricerca$%')
$endif$
group by (opera_titolo)