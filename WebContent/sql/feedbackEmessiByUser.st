select a.*, i1.`immagine_hash` as user_immagine_hash, i2.immagine_hash as opera_immagine_hash 
from ( select u2.*, feedback.*, opere.* from users u1, users u2, feedback, opere where 
feedback.`feedback_id_opera` = opere.`opera_id` 
and u1.user_id = $userId$ 
and u2.user_id = opere.opera_id_user
and feedback.`feedback_id_user` = u1.user_id) a 
left join immagini i1 on a.`user_foto` = i1.`immagine_id` 
left join immagini i2 on a.`opera_id_immagine` = i2.`immagine_id`