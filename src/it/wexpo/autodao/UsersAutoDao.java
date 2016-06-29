package it.wexpo.autodao;

import it.wexpo.beans.UsersBean;
import it.wexpo.beanparsers.UsersParser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import automation.constans.DataBase;
import automation.dao.GenericDao;

public class UsersAutoDao extends GenericDao<UsersBean>{

	UsersParser parser = new UsersParser();

	@Override
	public void setMap(UsersBean bean){
		DBmap.put( "user_id",bean.getUserId());
		DBmap.put( "user_nome",bean.getUserNome());
		DBmap.put( "user_cognome",bean.getUserCognome());
		DBmap.put( "user_data_nascita",bean.getUserDataNascita());
		DBmap.put( "user_luogo_residenza",bean.getUserLuogoResidenza());
		DBmap.put( "user_citta",bean.getUserCitta());
		DBmap.put( "user_nazione",bean.getUserNazione());
		DBmap.put( "user_foto",bean.getUserFoto());
		DBmap.put( "user_cv",bean.getUserCv());
		DBmap.put( "user_email",bean.getUserEmail());
		DBmap.put( "user_link",bean.getUserLink());
		DBmap.put( "user_password",bean.getUserPassword());
		DBmap.put( "user_id_ruolo",bean.getUserIdRuolo());
		DBmap.put( "user_active",bean.getUserActive());
		
		DBmap.put( "website",bean.getWebsite());
		DBmap.put( "facebook_link",bean.getFacebookLink());
		DBmap.put( "twitter_link",bean.getTwitterLink());
		DBmap.put( "youtube_link",bean.getYoutubeLink());
		DBmap.put( "google_link",bean.getGoogleLink());
		
		DBmap.put( "user_data_ins",bean.getUserDataIns());
	
	}

	@Override
	public UsersBean parseBean(ResultSet resultSet) throws SQLException {
		return parser.parseBean(resultSet);
	}

	@Override
	protected void defineTable() {
		this.TABLE = "users";
	}
	public UsersAutoDao(){
		super(DataBase.MYSQL);
	}
	
	public  Long insertGenKey(UsersBean bean, Connection conn) throws SQLException{
		setMap(bean);
		String sql = getInsertSQL(bean);
		printStatement(sql);
		Statement stmt = conn.createStatement();
		
		int x = 0;
		stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs != null && rs.next()) {
		    Long y = rs.getLong(1);
		    return y;
		}
		
		stmt.close();
		
		return null;
	}
}