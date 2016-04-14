package it.wexpo.beanparsers;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		bean.setOperaDateInsert(res.getDate("opera_insert"));
		bean.setOperaActive(res.getInt("opera_active"));
		try{
			bean.setFeedbackVoto(res.getInt("feedback_voto"));
		}catch(Exception e){}
		
		return bean;
	}
}