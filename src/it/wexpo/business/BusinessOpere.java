package it.wexpo.business;

import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.dao.OpereDao;
import it.wexpo.dao.QueryGenerator;
import it.wexpo.dao.SqlQuery;
import it.wexpo.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import automation.logging.LoggerFactorySimple;

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
			
			Long userId = espositore.getUserId();
			String sql = QueryGenerator.getInstance().getOperaUser(userId);
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
			String sql = QueryGenerator.getInstance().getOperaSql(type, null);
			
			System.out.println(sql);
			
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
			String sql = QueryGenerator.getInstance().getOperaSql(0, nome);
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
