package it.wexpo.autodao;

import it.wexpo.beans.ImmaginiBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.beanparsers.ImmaginiParser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import automation.constans.DataBase;
import automation.dao.GenericDao;

public class ImmaginiAutoDao extends GenericDao<ImmaginiBean>{

	ImmaginiParser parser = new ImmaginiParser();

	public ImmaginiAutoDao(){
		super(DataBase.MYSQL);
	}
	@Override
	public void setMap(ImmaginiBean bean){
		DBmap.put( "immagine_id",bean.getImmagineId());
		DBmap.put( "immagine_nome",bean.getImmagineNome());
		DBmap.put( "immagine_hash",bean.getImmagineHash());
	
	}

	@Override
	public ImmaginiBean parseBean(ResultSet resultSet) throws SQLException {
		return parser.parseBean(resultSet);
	}

	@Override
	protected void defineTable() {
		this.TABLE = "immagini";
	}
	
	public  Long insertGenKey(ImmaginiBean bean, Connection conn) throws SQLException{
		setMap(bean);
		String sql = getInsertSQL(bean);
		printStatement(sql);
		Statement stmt = conn.createStatement();
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