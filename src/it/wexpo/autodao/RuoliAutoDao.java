package it.wexpo.autodao;

import it.wexpo.beans.RuoliBean;
import it.wexpo.beanparsers.RuoliParser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import automation.dao.GenericDao;

public class RuoliAutoDao extends GenericDao<RuoliBean>{

	RuoliParser parser = new RuoliParser();

	@Override
	public void setMap(RuoliBean bean){
		DBmap.put( "ruolo_id",bean.getRuoloId());
		DBmap.put( "ruolo_descrizione",bean.getRuoloDescrizione());
	
	}

	@Override
	public RuoliBean parseBean(ResultSet resultSet) throws SQLException {
		return parser.parseBean(resultSet);
	}

	@Override
	protected void defineTable() {
		this.TABLE = "ruoli";
	}
	
}