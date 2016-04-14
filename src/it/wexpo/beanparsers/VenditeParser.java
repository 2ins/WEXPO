package it.wexpo.beanparsers;
import java.sql.ResultSet;
import java.sql.SQLException;
import automation.parser.BeanParser;
import it.wexpo.beans.VenditeBean;

public class VenditeParser implements BeanParser<VenditeBean>{
	public VenditeBean parseBean (ResultSet res) throws SQLException{
		VenditeBean bean = new VenditeBean();
		bean.setVenditaId(res.getLong("vendita_id"));
		bean.setVenditaStato(res.getString("vendita_stato"));
		bean.setVenditaNote(res.getString("vendita_note"));
		bean.setVenditaIdOpera(res.getLong("vendita_id_opera"));
		return bean;
	}
}