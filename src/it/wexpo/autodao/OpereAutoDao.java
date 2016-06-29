package it.wexpo.autodao;

import it.wexpo.beans.OpereBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.beanparsers.OpereParser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import automation.constans.DataBase;
import automation.dao.GenericDao;

public class OpereAutoDao extends GenericDao<OpereBean>{

	OpereParser parser = new OpereParser();
	
	public OpereAutoDao(){
		super(DataBase.MYSQL);
	}
	
	@Override
	public void setMap(OpereBean bean){
		DBmap.put( "opera_id",bean.getOperaId());
		DBmap.put( "opera_titolo",bean.getOperaTitolo());
		DBmap.put( "opera_descrizione",bean.getOperaDescrizione());
		DBmap.put( "opera_id_user",bean.getOperaIdUser());
		DBmap.put( "opera_rate_pop",bean.getOperaRatePop());
		DBmap.put( "opera_rate_crit",bean.getOperaRateCrit());
		DBmap.put( "opera_id_immagine",bean.getOperaIdImmagine());
		DBmap.put( "opera_rate_pop_feeds",bean.getOperaRatePopFeeds());
		DBmap.put( "opera_rate_crit_feeds",bean.getOperaRateCritFeeds());
		DBmap.put( "opera_insert",bean.getOperaInsert());
		DBmap.put( "opera_update",bean.getOperaUpdate());
		DBmap.put( "opera_active",bean.getOperaActive());
		
		DBmap.put( "opera_titolo_eng",bean.getOperaTitoloEng());
		DBmap.put( "opera_descrizione_eng",bean.getOperaDescrizioneEng());
	}

	@Override
	public OpereBean parseBean(ResultSet resultSet) throws SQLException {
		return parser.parseBean(resultSet);
	}

	@Override
	protected void defineTable() {
		this.TABLE = "opere";
	}
	
	public  Long insertGenKey(OpereBean bean, Connection conn) throws SQLException{
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