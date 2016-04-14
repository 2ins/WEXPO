package it.wexpo.autodao;

import it.wexpo.beans.OpereImmaginiBean;
import it.wexpo.beanparsers.OpereImmaginiParser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import automation.dao.GenericDao;

public class OpereImmaginiAutoDao extends GenericDao<OpereImmaginiBean>{

	OpereImmaginiParser parser = new OpereImmaginiParser();

	@Override
	public void setMap(OpereImmaginiBean bean){
		DBmap.put( "opera_immagine_id",bean.getOperaImmagineId());
		DBmap.put( "opera_immagine_id_immagine",bean.getOperaImmagineIdImmagine());
		DBmap.put( "opera_immagine_id_opera",bean.getOperaImmagineIdOpera());
	
	}

	@Override
	public OpereImmaginiBean parseBean(ResultSet resultSet) throws SQLException {
		return parser.parseBean(resultSet);
	}

	@Override
	protected void defineTable() {
		this.TABLE = "opere_immagini";
	}
	
}