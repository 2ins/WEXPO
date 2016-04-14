package it.wexpo.dao;

public class SqlQuery {

		public static String OPERE_SQL =
			"select *"+
			
			"from opere o, users u, immagini i "+
			"where u.user_id = o.opera_id_user and i.immagine_id = o.opera_id_immagine ";
		
		
		public static String OPERE_SQL_TIPO =
				"select * "+
				"from opere o, users u, immagini i "+
				"where u.user_id = o.opera_id_user and i.immagine_id = o.opera_id_immagine ";
		
		
		public static String OPERE_SQL_BY_GIUDICE =
			"select"+
			"o.opera_titolo, o.opera_descrizione, o.opera_id, o.opera_rate_pop, o.opera_rate_crit, "
			+ " o.opera_rate_pop_feeds, o.opera_rate_crit_feeds, "+
			"u.user_id, u.user_nome, u.user_cognome,  u.user_link,    "+
			"i.immagine_id, i.immagine_hash  "+
			",f.feedback_voto  "+
			"from opere o, users u, immagini i  "+
			", feedback f  "+
			"where u.user_id = o.opera_id_user and i.immagine_id = o.opera_id_immagine   "+
			"and f.feedback_id_opera = o.opera_id "
			+ "and f.feedback_id_user = ";
		
		
		public static String FEED_USER_BY_OPERA = 
			"select immagini.immagine_hash as user_immagine_hash, a.* "
			+ "from (select * from users, feedback "+
			"where feedback.feedback_id_user = users.`user_id` "+
			"and feedback.`feedback_id_opera` = ?) a "+
			"left join immagini on a.`user_foto` = immagini.`immagine_id`";
	
		
		public static String FEED_OPERA_OPERAUSER_BY_USER = 
			"select a.*, i1.`immagine_hash` as user_immagine_hash, i2.immagine_hash as opera_immagine_hash from "+
			"( select * from users, feedback, opere where "+
			"feedback.`feedback_id_opera` = opere.`opera_id` "
			+ "and users.user_id = ? "
			+ "and feedback.`feedback_id_user` = users.user_id) a "+
			"left join immagini i1 on a.`user_foto` = i1.`immagine_id` "+
			"left join immagini i2 on a.`opera_id_immagine` = i2.`immagine_id` ";
	
}
