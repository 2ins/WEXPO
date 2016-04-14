package it.wexpo.beanparsers;
import java.sql.ResultSet;
import java.sql.SQLException;

import automation.parser.BeanParser;
import it.wexpo.beans.UserViewBean;
import it.wexpo.beans.UsersBean;

public class UserViewParser implements BeanParser<UserViewBean>{
	public UserViewBean parseBean (ResultSet res) throws SQLException{
		UserViewBean bean = new UserViewBean();
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
		bean.setUserImmagine(res.getString("immagine_hash"));
		
		bean.setUserIdRuolo(res.getLong("user_id_ruolo"));
		
		try{
			bean.setOperaRatePop(res.getInt("opera_rate_pop"));
			bean.setOperaRateCrit(res.getInt("opera_rate_crit"));
			bean.setOperaRateCritFeeds(res.getInt("opera_rate_crit_feeds"));
			bean.setOperaRatePopFeeds(res.getInt("opera_rate_pop_feeds"));
			//solo per ricerca utenti
			bean.setNumeroOpere(res.getInt("opere")-1);
			
		}catch(Exception e){
			
		}
		return bean;
	}
}