package it.wexpo.business;

import it.wexpo.autodao.ImmaginiAutoDao;
import it.wexpo.beans.FeedbackOperaViewBean;
import it.wexpo.beans.ImmaginiBean;
import it.wexpo.beans.UserViewBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.dao.DettaglioUtenteDao;
import it.wexpo.dao.QueryGenerator;
import it.wexpo.dao.SqlQuery;
import it.wexpo.dao.UsersDao;
import it.wexpo.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class BusinessUtente {
	
	public static ArrayList<FeedbackOperaViewBean> selectAllFeeds(UsersBean user) throws SQLException{
		Connection conn = DbUtils.getMySqlConn();
		ArrayList<FeedbackOperaViewBean> list = null;
		try{
			String sql = QueryGenerator.getInstance().getFeedbackEmessi(user.getUserId());
			list = DettaglioUtenteDao.executeQweryMany(sql, conn, user);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
	}
	
	public static ArrayList<UserViewBean> ricercaView(UsersBean user) throws SQLException{
		Connection conn =  DbUtils.getMySqlConn();
		try {
			
			
			String sql = QueryGenerator.getInstance().getUtenti(user);
			
			System.out.println("#########");
			System.out.println(sql);
			System.out.println("#########");
			
			/*
				
			String condition = "(users.user_nome like '%"+str+"%' or users.user_cognome like '%"+str+"%')";
					
			
			String sql = "select count(*) opere, "
				+ "sum(opere.`opera_rate_crit`) opera_rate_crit, "
				+ "sum(opere.`opera_rate_pop`) opera_rate_pop, "
				+ "sum(opere.`opera_rate_crit_feeds`) opera_rate_crit_feeds, "
				+ "sum(opere.`opera_rate_pop_feeds`) opera_rate_pop_feeds, "
				+ "a.*,i.* from (select * from users where "+condition+") a "
				+ "left join immagini i on a.user_foto = i.immagine_id "
				+ "left join opere on opere.`opera_id_user` = a.user_id "
				+ "group by a.user_id ";
				*/
			return UsersDao.executeQweryMany(sql, conn);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}

	public static UserViewBean findView(UsersBean usr) throws SQLException{
		Connection conn =  DbUtils.getMySqlConn();
		try {
			String sql = "select * from (select * from "
					+ "users where users.user_id = "+usr.getUserId().toString()+" ) a "
					+ "left join immagini i on a.user_foto = i.immagine_id";
			
			ArrayList<UserViewBean> list = UsersDao.executeQweryMany(sql, conn);
			
			if (list.size()==0) return null;
				return list.get(0);
				
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}
	
	public static ImmaginiBean findFoto(long idFoto) throws SQLException{
		Connection conn =  DbUtils.getMySqlConn();
		try {
			
			ImmaginiBean bean = new ImmaginiBean();
			bean.setImmagineId(idFoto);
			ImmaginiAutoDao dao = new ImmaginiAutoDao();
			ArrayList<ImmaginiBean> list = dao.select(bean, conn);
			
			if (list.size()==0) return null;
				return list.get(0);
				
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}
	
}
