package it.wexpo.utils;

import java.sql.SQLException;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.http.SimpleSession;

import it.wexpo.autodao.UsersAutoDao;
import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.business.BusinessDao;

public class ApplicationUtils {
	
	public static UsersBean getLoggedUser() {
		SimpleSession s = (SimpleSession) Executions.getCurrent().getDesktop().getSession();
		return (UsersBean)s.getAttribute("USER");
	}
	
	public static String getRuolo() {
		SimpleSession s = (SimpleSession) Executions.getCurrent().getDesktop().getSession();
		return (String)s.getAttribute("RUOLO");
	}
	
	public static UsersBean getSelectedUser() {
		SimpleSession s = (SimpleSession) Executions.getCurrent().getDesktop().getSession();
		return (UsersBean)s.getAttribute("SELECTED_USER");
	}
	
	public static OperaViewBean getOperaSelected() {
		SimpleSession s = (SimpleSession) Executions.getCurrent().getDesktop().getSession();
		return (OperaViewBean)s.getAttribute("OPERA");
	}
	
	public static void setOperaSelected(OperaViewBean opera) {
		SimpleSession s = (SimpleSession) Executions.getCurrent().getDesktop().getSession();
		s.setAttribute("OPERA", opera);
	}
	
	public static void setLoggedUser(UsersBean user) {
		SimpleSession s = (SimpleSession) Executions.getCurrent().getDesktop().getSession();
		s.setAttribute("USER",user);
		s.setAttribute("RUOLO", user.getUserIdRuolo().toString());
	}
	
	public static void setSelectedUser(UsersBean user) {
		SimpleSession s = (SimpleSession) Executions.getCurrent().getDesktop().getSession();
		s.setAttribute("SELECTED_USER",user);
	}
	
	public static void clean(){
		SimpleSession s = (SimpleSession) Executions.getCurrent().getDesktop().getSession();
		s.removeAttribute("USER");
		s.removeAttribute("SELECTED_USER");
		s.removeAttribute("OPERA");
		s.removeAttribute("RUOLO");
	}
}
