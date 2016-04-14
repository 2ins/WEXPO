package it.wexpo.beanparsers;
import java.sql.ResultSet;
import java.sql.SQLException;
import automation.parser.BeanParser;
import it.wexpo.beans.ConcorsiBean;

public class ConcorsiParser implements BeanParser<ConcorsiBean>{
	public ConcorsiBean parseBean (ResultSet res) throws SQLException{
		ConcorsiBean bean = new ConcorsiBean();
		bean.setConcorsoId(res.getLong("concorso_id"));
		bean.setConcorsoTitolo(res.getString("concorso_titolo"));
		bean.setConcorsoDescrizione(res.getString("concorso_descrizione"));
		bean.setConcorsoIdImg1(res.getLong("concorso_id_img_1"));
		bean.setConcorsoIdImg2(res.getLong("concorso_id_img_2"));
		bean.setConcorsoIdImg3(res.getLong("concorso_id_img_3"));
		bean.setConcorsoDataIn(res.getDate("concorso_data_in"));
		bean.setConcorsoDataOut(res.getDate("concorso_data_out"));
		return bean;
	}
}