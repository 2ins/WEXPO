package it.wexpo.auth;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import it.wexpo.autodao.AutenticazioneAutoDao;
import it.wexpo.autodao.UsersAutoDao;
import it.wexpo.beans.AutenticazioneBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.dao.UsersDao;
import it.wexpo.mail.MailProcessor;
import it.wexpo.mail.MailSender;
import it.wexpo.utils.ApplicationUtils;
import it.wexpo.utils.DbUtils;

public class BusinessAutenticazione {

	public static void inserisciAuthInviaMail(UsersBean user, Connection conn) throws SQLException{
		String tipo = "INIT";
		String token = inserisciAutenticazione(user, conn, tipo);
		MailProcessor.eseguiBenvenuto(user,token);
	
	}

	public static void inserisciAuthInviaMailPasswordDimenticata(UsersBean user, Connection conn) throws SQLException{
		String tipo = "R_PSW";
		String token = inserisciAutenticazione(user, conn, tipo);
		MailProcessor.eseguiPasswordDimenticata(user,token);
	}
	

	public static void updatePassword(String p1, UsersBean user, Connection conn) throws SQLException {
		
		user.setUserPassword(p1);
		UsersAutoDao dao = new UsersAutoDao();
		UsersBean select = new UsersBean();
		select.setUserId(user.getUserId());
		dao.update(user, select, conn);
	}
	
	
	public static UsersBean autenticaAbilita(String token, boolean doLogin, Connection conn) throws Exception{
		 
		AutenticazioneAutoDao dao = new AutenticazioneAutoDao();
		AutenticazioneBean authBean = new AutenticazioneBean();
		
		authBean.setToken(token);
		
		ArrayList<AutenticazioneBean> autList =  dao.select(authBean, conn);
		
		if (autList.size()>0){
			
			AutenticazioneBean b = autList.get(0);
			
			//va tolta solamente se sono in fase di autorizzazione per accettazione utente
			//nel caso di cambio password non va eliminata
			if(doLogin){
				dao.delete(authBean, conn);
			}
			
			Long id = b.getIduser();
			
			UsersBean userSelect = new UsersBean();
			userSelect.setUserId(id);
			
			UsersAutoDao usersDao = new UsersAutoDao();
			ArrayList<UsersBean> listUser = usersDao.select(userSelect, conn);
			
			if (listUser.size()==0){
				throw new Exception("Utente non piu presente nel database");	
			}
			UsersBean userLogged = listUser.get(0);
			userLogged.setUserActive(1);
			usersDao.update(userLogged, userSelect, conn);
			
			
			
			return userLogged;
		
			
		} else{
			throw new Exception("Utente gia autenticato");
		}
		
		
		
	
	}
	
	
	
	public static void deleteAutorizzazioneRecord(String token, Connection conn) throws Exception{
		 
		AutenticazioneAutoDao dao = new AutenticazioneAutoDao();
		AutenticazioneBean authBean = new AutenticazioneBean();
		authBean.setToken(token);
		
		ArrayList<AutenticazioneBean> autList =  dao.select(authBean, conn);
		
		if (autList.size()>0){
			
			AutenticazioneBean b = autList.get(0);
			dao.delete(authBean, conn);
			
		} else{
			throw new Exception("Utente gia autenticato");
		}
		
		
		
	
	}
	
	
	
	
	private static String inserisciAutenticazione(UsersBean user,
			Connection conn, String tipo) throws SQLException {
		String token = TokenGenerator.generaToken();
		
		AutenticazioneAutoDao dao = new AutenticazioneAutoDao();
		AutenticazioneBean authBean = new AutenticazioneBean();
		
		authBean.setEmailuser(user.getUserEmail());
		authBean.setDate(new Date());
		authBean.setToken(token);
		authBean.setIduser(user.getUserId());
		authBean.setExpire(addOneMonth(authBean.getDate()));
		authBean.setTipo(tipo);
		dao.insert(authBean, conn);
		return token;
	}
	
	
	public static Date addOneMonth(Date date)
	{
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.MONTH, 1);
	    return cal.getTime();
	}
	
}
