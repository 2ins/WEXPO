package it.wexpo.autodao;

import it.wexpo.beans.VenditeBean;
import it.wexpo.beanparsers.VenditeParser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import automation.dao.GenericDao;

public class VenditeAutoDao extends GenericDao<VenditeBean>{

	VenditeParser parser = new VenditeParser();

	@Override
	public void setMap(VenditeBean bean){
		DBmap.put( "vendita_id",bean.getVenditaId());
		DBmap.put( "vendita_stato",bean.getVenditaStato());
		DBmap.put( "vendita_note",bean.getVenditaNote());
		DBmap.put( "vendita_id_opera",bean.getVenditaIdOpera());
	
	}

	@Override
	public VenditeBean parseBean(ResultSet resultSet) throws SQLException {
		return parser.parseBean(resultSet);
	}

	@Override
	protected void defineTable() {
		this.TABLE = "vendite";
	}
	
}