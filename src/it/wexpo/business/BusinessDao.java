package it.wexpo.business;

import it.wexpo.auth.BusinessAutenticazione;
import it.wexpo.autodao.ImmaginiAutoDao;
import it.wexpo.autodao.OpereAutoDao;
import it.wexpo.autodao.UsersAutoDao;
import it.wexpo.beans.ImmaginiBean;
import it.wexpo.beans.OpereBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.dao.Dao;
import it.wexpo.mail.MailProcessor;
import it.wexpo.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class BusinessDao {
	public static ArrayList<UsersBean> getUtenti(String nome, String cognome) throws SQLException{
		
		Connection conn = DbUtils.getMySqlConn();
		ArrayList<UsersBean> list = null;
		
		try{
			
			UsersAutoDao dao = new UsersAutoDao();
			UsersBean bean = new UsersBean();
			bean.setUserNome(nome);
			bean.setUserCognome(cognome);
			list = dao.select(bean, conn);
		
		}catch(Exception e){
			
			throw e;
		}finally{
			conn.close();
		}
		
		return list;
		
	}
	
	
public static Boolean getUtenteEmailEsistente(UsersBean user) throws SQLException{
		
		Connection conn = DbUtils.getMySqlConn();
		ArrayList<UsersBean> list = null;
		
		try{
			
			UsersAutoDao dao = new UsersAutoDao();
			UsersBean bean = new UsersBean();
			bean.setUserEmail(user.getUserEmail());
			list = dao.select(bean, conn);
			if (list.size()>0) return true;
			return false;
		}catch(Exception e){
			
			throw e;
		}finally{
			conn.close();
		}
		
		
		
	}
	
	
public static ArrayList<UsersBean> getUtentiPerRuolo(Long ruolo) throws SQLException{
		
		Connection conn = DbUtils.getMySqlConn();
		ArrayList<UsersBean> list = null;
		
		try{
			
			UsersAutoDao dao = new UsersAutoDao();
			UsersBean bean = new UsersBean();
			bean.setUserIdRuolo(ruolo);
			list = dao.select(bean, conn);
		
		}catch(Exception e){
			
			throw e;
		}finally{
			conn.close();
		}
		
		return list;
		
	}
	
	
	public static UsersBean getPrimoUtente() throws SQLException{
		
		Connection conn = DbUtils.getMySqlConn();
		ArrayList<UsersBean> list = null;
		
		try{
			UsersBean bean = new UsersBean();
			UsersAutoDao dao = new UsersAutoDao();
			bean.setUserId(new Long(1));
			
			list = dao.select(bean, conn);
			return list.get(0);
		
		}catch(Exception e){
			
			throw e;
		}finally{
			conn.close();
		}
		
		
		
	}





public static Long salvaOpera(OpereBean opera, ImmaginiBean imgBean, UsersBean user) throws SQLException {
	Connection conn = DbUtils.getMySqlConn();
	
	try{
		OpereAutoDao dao = new OpereAutoDao();
		ImmaginiAutoDao imgDao = new ImmaginiAutoDao();
		Long idImg = imgDao.insertGenKey(imgBean, conn);
		System.out.println("id img :"+idImg);
		opera.setOperaInsert(new Date());
		opera.setOperaIdImmagine(idImg);
		opera.setOperaIdUser(user.getUserId());
		Long x = dao.insertGenKey(opera, conn);
			
		conn.commit();
		return x;
		
	}catch(Exception e){
		e.printStackTrace();
		throw e;
	}finally{
		conn.close();
	}
	
	
}
}
