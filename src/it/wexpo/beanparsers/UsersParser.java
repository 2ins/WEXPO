package it.wexpo.beanparsers;
import java.sql.ResultSet;
import java.sql.SQLException;

import automation.parser.BeanParser;
import it.wexpo.beans.UsersBean;
import it.wexpo.utils.DomainMapper;

public class UsersParser implements BeanParser<UsersBean>{
	public UsersBean parseBean (ResultSet res) throws SQLException{
		UsersBean bean = new UsersBean();
		
		bean.setUserId(res.getLong("user_id"));
		bean.setUserNome(res.getString("user_nome"));
		bean.setUserCognome(res.getString("user_cognome"));
		bean.setUserDataNascita(res.getDate("user_data_nascita"));
		bean.setUserLuogoResidenza(res.getString("user_luogo_residenza"));
		bean.setUserCitta(res.getString("user_citta"));
		bean.setUserNazione(res.getString("user_nazione"));
		bean.setUserFoto(res.getLong("user_foto"));
		bean.setUserCv(res.getLong("user_cv"));
		bean.setUserEmail(res.getString("user_email"));
		bean.setUserLink(res.getString("user_link"));
		bean.setUserPassword(res.getString("user_password"));
		bean.setUserIdRuolo(res.getLong("user_id_ruolo"));
		bean.setUserActive(res.getInt("user_active"));
		
		bean.setWebsite(res.getString("website"));
		bean.setYoutubeLink(res.getString("youtube_link"));
		bean.setGoogleLink(res.getString("google_link"));
		bean.setTwitterLink(res.getString("twitter_link"));
		bean.setFacebookLink(res.getString("facebook_Link"));
		
		bean.setUserDataIns(res.getDate("user_data_ins"));
		
		try {
			bean.setRuolo(DomainMapper.getRuolo(bean.getUserIdRuolo()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException("ruolo non mappato - "+e.getMessage());
		}
		
		return bean;
	}
}