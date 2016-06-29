select opera_titolo,opera_descrizione, 
opera_titolo_eng,opera_descrizione_eng, 
opera_id,user_id,user_nome,
user_cognome,user_link,immagine_id,immagine_hash,opera_insert,opera_active,
count(f1.feedback_id_opera) opera_rate_pop_feeds, avg(f1.feedback_voto) media_pop, sum(f1.feedback_voto) opera_rate_pop,
count(f1.feedback_id_opera) opera_rate_crit_feeds, avg(f1.feedback_voto) media_crit, sum(f1.feedback_voto) opera_rate_crit
from  users u, immagini i, opere o
inner join feedback f1 on (f1.feedback_id_opera = o.opera_id and  f1.feedback_tipo=$tipo$)
where u.user_id = o.opera_id_user 
and i.immagine_id = o.opera_id_immagine 
and o.opera_active = 1
and u.user_active = 1
group by (opera_titolo)