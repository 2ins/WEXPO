package it.wexpo.beanparsers;
import java.sql.ResultSet;
import java.sql.SQLException;

import automation.parser.BeanParser;
import it.wexpo.beans.FeedbackBean;
import it.wexpo.beans.FeedbackOperaViewBean;
import it.wexpo.beans.FeedbackViewBean;

public class FeedbackOperaViewParser extends FeedbackViewParser{
	public FeedbackOperaViewBean parseBean (ResultSet res) throws SQLException{
		
		
		FeedbackOperaViewBean bean = new FeedbackOperaViewBean();
		
		bean.setFeedbackId(res.getLong("feedback_id"));
		bean.setFeedbackVoto(res.getInt("feedback_voto"));
		bean.setFeedbackDescrizione(res.getString("feedback_descrizione"));
		bean.setFeedbackIdOpera(res.getLong("feedback_id_opera"));
		bean.setFeedbackIdUser(res.getLong("feedback_id_user"));
		bean.setFeedbackTipo(res.getInt("feedback_tipo"));
		bean.setUserNome(res.getString("user_nome"));
		bean.setUserCognome(res.getString("user_cognome"));
		bean.setUserHashFoto(res.getString("user_immagine_hash"));
		bean.setUserId(res.getLong("user_id"));
		bean.setOperaTitolo(res.getString("a.opera_titolo"));
		bean.setOperaDescrizione(res.getString("a.opera_descrizione"));
		bean.setOperaId(res.getLong("a.opera_id"));
		bean.setOperaHashFoto(res.getString("opera_immagine_hash"));
		
		return bean;
	}
}