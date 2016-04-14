package it.wexpo.vm;

import it.wexpo.beans.ImmaginiBean;
import it.wexpo.beans.RuoliBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.business.Business;
import it.wexpo.business.BusinessDao;
import it.wexpo.business.BusinessLogin;
import it.wexpo.utils.ApplicationUtils;
import it.wexpo.utils.WexpoMediaUtils;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.io.Files;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Messagebox;

public class LoginVm {

	private UsersBean user;
	 
	private String password = null;
	private String login = null;

	
	@Init
	@NotifyChange("*")
	public void init(){
		
	}


	
	@Command("login")
	@NotifyChange("*")
	public void login()  throws IOException {
		try {
			ArrayList<UsersBean> list = BusinessLogin.getUtenti(login, password);
			if (list.size()==1){
				user = list.get(0);
				ApplicationUtils.setLoggedUser(user);
				Executions.sendRedirect("/index.zul");
			}else{
				Messagebox.show("login non effettuata");
			}
		} catch (SQLException e) {
			Messagebox.show("errore durante connessione db");
		}
	}

	
	
	@Command("passwordForget")
	@NotifyChange("*")
	public void passwordForget()  throws IOException {
		try {
			BusinessLogin.resetPasswordAutenticaInviaMailTransational(login);
		} catch (Exception e) {
			Messagebox.show(e.getMessage());
		}
	}

	

	public UsersBean getUser() {
		return user;
	}



	public void setUser(UsersBean user) {
		this.user = user;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}
	   
		
		
	

	
}
