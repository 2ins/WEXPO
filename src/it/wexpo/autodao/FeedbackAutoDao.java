package it.wexpo.autodao;

import it.wexpo.beans.FeedbackBean;
import it.wexpo.beans.OpereBean;
import it.wexpo.beanparsers.FeedbackParser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import automation.dao.GenericDao;

public class FeedbackAutoDao extends GenericDao<FeedbackBean>{

	FeedbackParser parser = new FeedbackParser();

	@Override
	public void setMap(FeedbackBean bean){
		DBmap.put( "feedback_id",bean.getFeedbackId());
		DBmap.put( "feedback_voto",bean.getFeedbackVoto());
		DBmap.put( "feedback_descrizione",bean.getFeedbackDescrizione());
		DBmap.put( "feedback_id_opera",bean.getFeedbackIdOpera());
		DBmap.put( "feedback_id_user",bean.getFeedbackIdUser());
		DBmap.put( "feedback_tipo",bean.getFeedbackTipo());
	
	}

	@Override
	public FeedbackBean parseBean(ResultSet resultSet) throws SQLException {
		return parser.parseBean(resultSet);
	}

	@Override
	protected void defineTable() {
		this.TABLE = "feedback";
	}
	
	public  Long insertGenKey(FeedbackBean bean, Connection conn) throws SQLException{
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