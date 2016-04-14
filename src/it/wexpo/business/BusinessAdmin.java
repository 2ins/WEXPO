package it.wexpo.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.wexpo.autodao.FeedbackAutoDao;
import it.wexpo.autodao.OpereAutoDao;
import it.wexpo.autodao.UsersAutoDao;
import it.wexpo.bean.compo.OperaImmagineBean;
import it.wexpo.bean.compo.UserImmagineBean;
import it.wexpo.beanparsers.FeedbackBigParser;
import it.wexpo.beanparsers.UsersParser;
import it.wexpo.beans.FeedbackBean;
import it.wexpo.beans.FeedbackBigBean;
import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.OpereBean;
import it.wexpo.beans.UserViewBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.dao.OpereDao;
import it.wexpo.dao.QueryGenerator;
import it.wexpo.dao.SqlQuery;
import it.wexpo.dao.UsersDao;
import it.wexpo.dao.compo.OpereImmagineDao;
import it.wexpo.dao.compo.UserImmagineDao;
import it.wexpo.utils.DbUtils;
import it.wexpo.utils.WexpoMediaUtils;
import it.zone.business.AbstractBusiness;
import it.zone.business.GenericSqlService;


public class BusinessAdmin {

public static ArrayList<FeedbackBigBean> cerca(FeedbackBigBean cerca) throws SQLException{
		
	
		FeedbackBigParser parser = new FeedbackBigParser();
		Connection conn = DbUtils.getMySqlConn();
		
		try {

			String sql = QueryGenerator.getInstance().getFeedback(cerca);
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			ArrayList<FeedbackBigBean> list = new ArrayList<FeedbackBigBean>();
			while (resultSet.next()){
				FeedbackBigBean bean = parser.parseBean(resultSet);
				list.add(bean);
		    }
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}
	

	
public static ArrayList<OperaImmagineBean> cerca(OpereBean cerca) throws SQLException{
		
		Connection conn = DbUtils.getMySqlConn();
		OpereImmagineDao dao = new OpereImmagineDao();
		
		OperaImmagineBean bean = new OperaImmagineBean();
		bean.setOpera(cerca);
		
		try {
			return  dao.select(bean, conn);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}
	
	
	public static ArrayList<UserImmagineBean> cerca(UsersBean cerca) throws SQLException{
		
		Connection conn = DbUtils.getMySqlConn();
		UserImmagineDao dao = new UserImmagineDao();
		UserImmagineBean bean = new UserImmagineBean();
		bean.setUser(cerca);
		
		ArrayList<UserImmagineBean> list = new ArrayList<UserImmagineBean>();
		try {
			list =  dao.select(bean, conn);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}
	
public static void aggionraUser(UsersBean user) throws SQLException{
		
		Connection conn = DbUtils.getMySqlConn();
	 
		try {
			
			UsersAutoDao dao = new UsersAutoDao();
			UsersBean userSelect = new UsersBean();
			userSelect.setUserId(user.getUserId());
			dao.update(user, userSelect, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}


public static void aggiornaUtenti(ArrayList<UsersBean> modificati) throws SQLException {
	Connection conn = DbUtils.getMySqlConn();
	 
	try {
		for (UsersBean u:modificati){
			UsersAutoDao dao = new UsersAutoDao();
			UsersBean userSelect = new UsersBean();
			userSelect.setUserId(u.getUserId());
			dao.update(u, userSelect, conn);
		}
		conn.commit();
	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	}finally{
		conn.close();
	}
	
}


public static void aggiornaOpere(ArrayList<OpereBean> modificati) throws SQLException {
	Connection conn = DbUtils.getMySqlConn();
	 
	try {
		for (OpereBean o:modificati){
			OpereAutoDao dao = new OpereAutoDao();
			OpereBean opSelect = new OpereBean();
			opSelect.setOperaId(o.getOperaId());
			dao.update(o, opSelect, conn);
		}
		conn.commit();
	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	}finally{
		conn.close();
	}
	
}



public static void aggiornaFeedback(ArrayList<FeedbackBigBean> modificati) throws SQLException {
	// TODO Auto-generated method stub
	
}
	

}