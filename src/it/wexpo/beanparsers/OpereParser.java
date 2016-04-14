package it.wexpo.beanparsers;
import java.sql.ResultSet;
import java.sql.SQLException;
import automation.parser.BeanParser;
import it.wexpo.beans.OpereBean;

public class OpereParser implements BeanParser<OpereBean>{
	public OpereBean parseBean (ResultSet res) throws SQLException{
		OpereBean bean = new OpereBean();
		bean.setOperaId(res.getLong("opera_id"));
		bean.setOperaTitolo(res.getString("opera_titolo"));
		bean.setOperaDescrizione(res.getString("opera_descrizione"));
		bean.setOperaIdUser(res.getLong("opera_id_user"));
		bean.setOperaRatePop(res.getInt("opera_rate_pop"));
		bean.setOperaRateCrit(res.getInt("opera_rate_crit"));
		bean.setOperaIdImmagine(res.getLong("opera_id_immagine"));
		bean.setOperaRateCritFeeds(res.getInt("opera_rate_crit_feeds"));
		bean.setOperaRatePopFeeds(res.getInt("opera_rate_pop_feeds"));
		bean.setOperaInsert(res.getDate("opera_insert"));
		bean.setOperaUpdate(res.getDate("opera_update"));
		bean.setOperaActive(res.getInt("opera_active"));
		return bean;
	}
}