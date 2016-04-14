package it.wexpo.beanparsers;
import java.sql.ResultSet;
import java.sql.SQLException;
import automation.parser.BeanParser;
import it.wexpo.beans.ImmaginiBean;

public class ImmaginiParser implements BeanParser<ImmaginiBean>{
	public ImmaginiBean parseBean (ResultSet res) throws SQLException{
		ImmaginiBean bean = new ImmaginiBean();
		bean.setImmagineId(res.getLong("immagine_id"));
		bean.setImmagineNome(res.getString("immagine_nome"));
		bean.setImmagineHash(res.getString("immagine_hash"));
		bean.setFormat(res.getString("immagine_format"));
		return bean;
	}
}