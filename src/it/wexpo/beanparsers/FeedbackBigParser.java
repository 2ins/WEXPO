package it.wexpo.beanparsers;
import it.wexpo.beans.FeedbackBigBean;

import java.sql.ResultSet;
import java.sql.SQLException;

import automation.parser.BeanParser;


public class FeedbackBigParser implements BeanParser<FeedbackBigBean>{
	public FeedbackBigBean parseBean (ResultSet res) throws SQLException{
		FeedbackBigBean bean = new FeedbackBigBean();
		bean.setFeedbackId(res.getLong("feedback_id"));
		bean.setFeedbackVoto(res.getInt("feedback_voto"));
		bean.setFeedbackDescrizione(res.getString("feedback_descrizione"));
		bean.setFeedbackIdOpera(res.getLong("feedback_id_opera"));
		bean.setFeedbackDate(res.getDate("feedback_date"));
		bean.setOperaId(res.getLong("opera_id"));
		bean.setOperaActive(res.getInt("opera_active"));
		bean.setOperaDescrizione(res.getString("opera_descrizione"));
		bean.setOperaIdImmagine(res.getLong("opera_id_immagine"));
		bean.setUserFeedbackId(res.getLong("user_feedback_id"));
		bean.setUserFeedbackNome(res.getString("user_feedback_nome"));
		bean.setUserFeedbackCognome(res.getString("user_feedback_cognome"));
		bean.setUserFeedbackFoto(res.getLong("user_feedback_foto"));
		bean.setUserFeedbackIdRuolo(res.getLong("user_feedback_id_ruolo"));
		bean.setUserOperaId(res.getLong("user_opera_id"));
		bean.setUserOperaNome(res.getString("user_opera_nome"));
		bean.setUserOperaCognome(res.getString("user_opera_cognome"));
		bean.setUserOperaFoto(res.getLong("user_opera_foto"));
		bean.setUserOperaIdRuolo(res.getLong("user_opera_id_ruolo"));
		bean.setUserFeedbackImmagineHash(res.getString("user_feedback_immagine_hash"));
		bean.setUserOperaImmagineHash(res.getString("user_opera_immagine_hash"));
		bean.setOperaImmagineHash(res.getString("opera_immagine_hash"));
		return bean;
	}
}