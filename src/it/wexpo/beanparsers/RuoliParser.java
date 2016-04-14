package it.wexpo.beanparsers;
import java.sql.ResultSet;
import java.sql.SQLException;
import automation.parser.BeanParser;
import it.wexpo.beans.RuoliBean;

public class RuoliParser implements BeanParser<RuoliBean>{
	public RuoliBean parseBean (ResultSet res) throws SQLException{
		RuoliBean bean = new RuoliBean();
		bean.setRuoloId(res.getLong("ruolo_id"));
		bean.setRuoloDescrizione(res.getString("ruolo_descrizione"));
		return bean;
	}
}