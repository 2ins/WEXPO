package it.wexpo.business;

import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.dao.OpereDao;
import it.wexpo.dao.SqlQuery;
import it.wexpo.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class BusinessOpere {
	public static ArrayList<OperaViewBean> cercaOpereGiudeice(UsersBean giudice) throws SQLException{
		Connection conn = DbUtils.getMySqlConn();
		try {
			String sql = SqlQuery.OPERE_SQL_BY_GIUDICE;
			sql = sql + giudice.getUserId();
			return OpereDao.executeQweryMany(sql, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}
	
	public static ArrayList<OperaViewBean> cercaOpereEspositore(UsersBean espositore) throws SQLException{
		Connection conn = DbUtils.getMySqlConn();
		try {
			String sql = SqlQuery.OPERE_SQL;
			
			sql = sql + " and u.user_id = "+espositore.getUserId() + " order by opera_insert desc";
			
			return OpereDao.executeQweryMany(sql, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}
	
	
	public static ArrayList<OperaViewBean> cercaOpere(int type) throws SQLException{
		Connection conn = DbUtils.getMySqlConn();
		try {
			String sql = SqlQuery.OPERE_SQL;
			
			if(type == 0){
				sql += " order by opera_insert desc";
			}else if(type==1){
				sql += " and opera_rate_pop <> 0 order by `opera_rate_pop`  desc";
			} else if(type==2){
				sql += " and opera_rate_crit <> 0 order by `opera_rate_crit`  desc";
			} 
			
			return OpereDao.executeQweryMany(sql, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}
	
	public static ArrayList<OperaViewBean> cercaOpereNome(String nome) throws SQLException{
		Connection conn = DbUtils.getMySqlConn();
		try {
			String sql = SqlQuery.OPERE_SQL;
			sql = sql + " and ( o.opera_titolo  like '%"+nome+"%'   or  o.opera_descrizione  like '%"+nome+"%')";
			System.out.println(sql);
			return OpereDao.executeQweryMany(sql, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}
}