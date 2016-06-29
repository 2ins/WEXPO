select immagini.immagine_hash as user_immagine_hash, a.*
from (select * from users, feedback 
where feedback.feedback_id_user = users.`user_id` 
and feedback.`feedback_id_opera` = $opera_id$
and feedback.feedback_tipo = 2
) a 
left join immagini on a.`user_foto` = immagini.`immagine_id`