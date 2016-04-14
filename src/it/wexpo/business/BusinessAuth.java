package it.wexpo.business;

import it.wexpo.auth.BusinessAutenticazione;
import it.wexpo.autodao.UsersAutoDao;
import it.wexpo.bean.compo.OperaImmagineBean;
import it.wexpo.beans.OpereBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.dao.compo.OpereImmagineDao;
import it.wexpo.utils.ApplicationUtils;
import it.wexpo.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class BusinessAuth {
	
	
	public static UsersBean ExecuteAuth(String token, boolean doLogin) throws Exception{
		
		Connection conn = DbUtils.getMySqlConn();
		
		try {
			UsersBean u = BusinessAutenticazione.autenticaAbilita(token, doLogin, conn);
			if (doLogin){
				loggaUtenza(u);
			}
			conn.commit();
			return u;
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}


	public static void ChangePasswordDleteAuthLogUser(String p1, String token, UsersBean user) throws Exception {
	
		Connection conn = DbUtils.getMySqlConn();
		
		try {
			BusinessAutenticazione.deleteAutorizzazioneRecord(token, conn);
			BusinessAutenticazione.updatePassword(p1, user, conn);
			loggaUtenza(user);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
	
	}


	private static void loggaUtenza(UsersBean u) {
	
		ApplicationUtils.clean();
		ApplicationUtils.setLoggedUser(u);
		
	}

}
