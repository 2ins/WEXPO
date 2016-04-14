package it.wexpo.beanparsers;
import it.wexpo.beans.AutenticazioneBean;

import java.sql.ResultSet;
import java.sql.SQLException;

import automation.parser.BeanParser;


public class AutenticazioneParser implements BeanParser<AutenticazioneBean>{
	public AutenticazioneBean parseBean (ResultSet res) throws SQLException{
		AutenticazioneBean bean = new AutenticazioneBean();
		bean.setIduser(res.getLong("idUser"));
		bean.setEmailuser(res.getString("emailUser"));
		bean.setToken(res.getString("token"));
		bean.setDate(res.getDate("date"));
		bean.setExpire(res.getDate("expire"));
		bean.setTipo(res.getString("tipo"));
		return bean;
	}
}