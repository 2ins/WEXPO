package it.wexpo.beanparsers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import automation.parser.BeanParser;
import it.wexpo.beans.OperaViewBean;

public class OperaViewParser implements BeanParser<OperaViewBean>{
	public OperaViewBean parseBean (ResultSet res) throws SQLException{
		OperaViewBean bean = new OperaViewBean();
		bean.setOperaTitolo(res.getString("opera_titolo"));
		bean.setOperaDescrizione(res.getString("opera_descrizione"));
		bean.setOperaId(res.getLong("opera_id"));
		bean.setOperaRatePop(res.getInt("opera_rate_pop"));
		bean.setOperaRateCrit(res.getInt("opera_rate_crit"));
		bean.setOperaRateCritFeeds(res.getInt("opera_rate_crit_feeds"));
		bean.setOperaRatePopFeeds(res.getInt("opera_rate_pop_feeds"));
		bean.setUserId(res.getLong("user_id"));
		bean.setUserNome(res.getString("user_nome"));
		bean.setUserCognome(res.getString("user_cognome"));
		bean.setUserLink(res.getString("user_link"));
		bean.setImmagineId(res.getLong("immagine_id"));
		bean.setImmagineHash(res.getString("immagine_hash"));
		bean.setOperaDateInsert(res.getTimestamp("opera_insert"));
		bean.setOperaActive(res.getInt("opera_active"));
		
		bean.setOperaTitoloEng(res.getString("opera_titolo_eng"));
		bean.setOperaDescrizioneEng(res.getString("opera_descrizione_eng"));
		
		
		try{
			bean.setWebsite(res.getString("website"));
			bean.setYoutubeLink(res.getString("youtube_link"));
			bean.setGoogleLink(res.getString("google_link"));
			bean.setTwitterLink(res.getString("twitter_link"));
			bean.setFacebookLink(res.getString("facebook_Link"));
		}catch(Exception e){}
		
		try{
			String tags = res.getString("tags");
			if (tags!=null){
				String[] parts = tags.split("#@#");
				bean.setTags(new ArrayList<String>(Arrays.asList(parts)));
			}else{
				bean.setTags(new ArrayList<String>());
			}
			
		}catch(Exception e){}
		
		try{
			bean.setFeedbackVoto(res.getInt("feedback_voto"));
		}catch(Exception e){}
		
		return bean;
	}
}