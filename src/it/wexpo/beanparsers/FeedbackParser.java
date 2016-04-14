package it.wexpo.beanparsers;
import java.sql.ResultSet;
import java.sql.SQLException;
import automation.parser.BeanParser;
import it.wexpo.beans.FeedbackBean;

public class FeedbackParser implements BeanParser<FeedbackBean>{
	public FeedbackBean parseBean (ResultSet res) throws SQLException{
		FeedbackBean bean = new FeedbackBean();
		bean.setFeedbackId(res.getLong("feedback_id"));
		bean.setFeedbackVoto(res.getInt("feedback_voto"));
		bean.setFeedbackDescrizione(res.getString("feedback_descrizione"));
		bean.setFeedbackIdOpera(res.getLong("feedback_id_opera"));
		bean.setFeedbackIdUser(res.getLong("feedback_id_user"));
		bean.setFeedbackTipo(res.getInt("feedback_tipo"));
		return bean;
	}
}