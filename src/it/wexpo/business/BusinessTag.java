package it.wexpo.business;

import it.wexpo.autodao.TagAutoDao;
import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.TagBean;
import it.wexpo.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class BusinessTag {
	
	
	public static void eliminaTag(TagBean bean) throws SQLException{
		Connection conn = DbUtils.getMySqlConn();
		try {
			
			TagAutoDao dao = new TagAutoDao();
			dao.delete(bean, conn);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}
	
	
	public static ArrayList<TagBean> caricaTag(TagBean bean) throws SQLException{
		Connection conn = DbUtils.getMySqlConn();
		try {
			
			TagAutoDao dao = new TagAutoDao();
			
			return dao.select(bean, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}
	
	public static ArrayList<TagBean> caricaTagDesc(TagBean bean) throws SQLException{
		Connection conn = DbUtils.getMySqlConn();
		try {
			
			TagAutoDao dao = new TagAutoDao();
			
			return dao.selectByDesc(bean, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}
	
	
	public static void salvaTag(TagBean bean) throws SQLException{
		Connection conn = DbUtils.getMySqlConn();
		try {
			
			TagAutoDao dao = new TagAutoDao();
			dao.insert(bean, conn);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}

}
