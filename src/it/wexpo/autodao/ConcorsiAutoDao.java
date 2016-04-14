package it.wexpo.autodao;

import it.wexpo.beans.ConcorsiBean;
import it.wexpo.beanparsers.ConcorsiParser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import automation.dao.GenericDao;

public class ConcorsiAutoDao extends GenericDao<ConcorsiBean>{

	ConcorsiParser parser = new ConcorsiParser();

	@Override
	public void setMap(ConcorsiBean bean){
		DBmap.put( "concorso_id",bean.getConcorsoId());
		DBmap.put( "concorso_titolo",bean.getConcorsoTitolo());
		DBmap.put( "concorso_descrizione",bean.getConcorsoDescrizione());
		DBmap.put( "concorso_id_img_1",bean.getConcorsoIdImg1());
		DBmap.put( "concorso_id_img_2",bean.getConcorsoIdImg2());
		DBmap.put( "concorso_id_img_3",bean.getConcorsoIdImg3());
		DBmap.put( "concorso_data_in",bean.getConcorsoDataIn());
		DBmap.put( "concorso_data_out",bean.getConcorsoDataOut());
	
	}

	@Override
	public ConcorsiBean parseBean(ResultSet resultSet) throws SQLException {
		return parser.parseBean(resultSet);
	}

	@Override
	protected void defineTable() {
		this.TABLE = "concorsi";
	}
	
}