package it.wexpo.beanparsers;
import java.sql.ResultSet;
import java.sql.SQLException;
import automation.parser.BeanParser;
import it.wexpo.beans.OpereImmaginiBean;

public class OpereImmaginiParser implements BeanParser<OpereImmaginiBean>{
	public OpereImmaginiBean parseBean (ResultSet res) throws SQLException{
		OpereImmaginiBean bean = new OpereImmaginiBean();
		bean.setOperaImmagineId(res.getLong("opera_immagine_id"));
		bean.setOperaImmagineIdImmagine(res.getLong("opera_immagine_id_immagine"));
		bean.setOperaImmagineIdOpera(res.getLong("opera_immagine_id_opera"));
		return bean;
	}
}