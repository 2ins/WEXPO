package it.wexpo.autodao;



import it.wexpo.beanparsers.AutenticazioneParser;
import it.wexpo.beans.AutenticazioneBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import automation.constans.DataBase;
import automation.dao.GenericDao;

public class AutenticazioneAutoDao extends GenericDao<AutenticazioneBean>{

	AutenticazioneParser parser = new AutenticazioneParser();

	public AutenticazioneAutoDao() {
		super(DataBase.MYSQL);
	}
	@Override
	public void setMap(AutenticazioneBean bean){
		DBmap.put( "idUser",bean.getIduser());
		DBmap.put( "emailUser",bean.getEmailuser());
		DBmap.put( "token",bean.getToken());
		DBmap.put( "date",bean.getDate());
		DBmap.put( "expire",bean.getExpire());
		DBmap.put( "tipo",bean.getTipo());
	
	}

	@Override
	public AutenticazioneBean parseBean(ResultSet resultSet) throws SQLException {
		return parser.parseBean(resultSet);
	}

	@Override
	protected void defineTable() {
		this.TABLE = "AUTENTICAZIONI";
	}
	
}