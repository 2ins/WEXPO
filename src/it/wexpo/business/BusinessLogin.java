package it.wexpo.business;

import it.wexpo.auth.BusinessAutenticazione;
import it.wexpo.autodao.UsersAutoDao;
import it.wexpo.beans.ImmaginiBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.dao.Dao;
import it.wexpo.dao.UsersDao;
import it.wexpo.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class BusinessLogin {
	
	
	
	
public static void salvaUtenteAutenticaInviaMailTransational(UsersBean user,ImmaginiBean imgBean, ImmaginiBean cv) throws Exception{
		
		Connection conn = DbUtils.getMySqlConn();
		
		try{
			boolean inviaMailCondition = (user.getUserId()==null);
			Dao.salvaUtenteImmagineAuth(user, imgBean, cv,  conn);
			
			if(inviaMailCondition){
				BusinessAutenticazione.inserisciAuthInviaMail(user,conn);
			}
			
			conn.commit();
			
 			
 			
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
			throw e;
		}finally{
			conn.close();
		}
		
		
		
	}




public static void resetPasswordAutenticaInviaMailTransational(String mail) throws Exception{
	
	Connection conn = DbUtils.getMySqlConn();
	
	try{
		
		UsersBean user = getUserByEmail(mail, conn);
		BusinessAutenticazione.inserisciAuthInviaMailPasswordDimenticata(user,conn);
		
		conn.commit();
	}catch(Exception e){
		e.printStackTrace();
		conn.rollback();
		throw e;
	}finally{
		conn.close();
	}
	
	
	
}




private static UsersBean getUserByEmail(String mail, Connection conn)
		throws SQLException {
	UsersBean user;
	
	UsersAutoDao dao = new UsersAutoDao();
	UsersBean userSelect = new UsersBean();
	userSelect.setUserEmail(mail);
	ArrayList<UsersBean> listUser = dao.select(userSelect, conn);
	
	if (listUser.size()==0){
		throw new SQLException("Nessun utente associato a questa mail");
	}else{
		user=listUser.get(0);
	}
	return user;
}
	
	
public static ArrayList<UsersBean> getUtenti(String login, String password) throws SQLException{
		
		Connection conn = DbUtils.getMySqlConn();
		ArrayList<UsersBean> list = null;
		
		try{
			
			UsersAutoDao dao = new UsersAutoDao();
			UsersBean bean = new UsersBean();
			bean.setUserEmail(login);
			bean.setUserPassword(password);
			list = dao.select(bean, conn);
			return list;
		}catch(Exception e){
			
			throw e;
		}finally{
			conn.close();
		}
		
		
		
	}
}
