select 

count(*) opere,
count(f1.feedback_id_opera) opera_rate_pop_feeds, avg(f1.feedback_voto), sum(f1.feedback_voto) opera_rate_pop,
count(f2.feedback_id_opera) opera_rate_crit_feeds, avg(f2.feedback_voto), sum(f2.feedback_voto) opera_rate_crit,

a.*, i.*


from (
select * from users 
where (
true = true

$if(nome)$
	and users.user_nome like '%$nome$%' 
$endif$	

$if(cognome)$
	and users.user_cognome like '%$cognome$%' 
$endif$	

$if(citta)$
	and users.user_citta like '%$citta$%' 
$endif$	

$if(nazione)$
	and users.user_nazione like '%$nazione$%' 
$endif$	

)

) a 

left join immagini i on a.user_foto = i.immagine_id 
left join opere on (opere.`opera_id_user` = a.user_id)
left join feedback f1 on (f1.feedback_id_opera = opere.opera_id and  f1.feedback_tipo=1)
left join feedback f2 on (f2.feedback_id_opera = opere.opera_id and  f2.feedback_tipo=2)

group by a.user_id 