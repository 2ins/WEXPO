package it.wexpo.auth.vm;

import it.wexpo.beans.UsersBean;
import it.wexpo.business.BusinessAuth;
import it.wexpo.business.BusinessLogin;
import it.wexpo.utils.ApplicationUtils;
import it.wexpo.utils.EnvironmentUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Messagebox;

public class AuthVm {
	
	private String status;
	
	@Init
	@NotifyChange("*")
	public void init(){
		
		
		Execution e = Executions.getCurrent();
		HttpServletRequest request = (HttpServletRequest) e.getNativeRequest();
		String token  = request.getParameter("token");
        
		try {
			BusinessAuth.ExecuteAuth(token,true);
			status = "Complimenti autenticazione riuscita fra poco sarai rediretto alla land page";
			
		} catch (Exception e1) {
			status = "AUTENTICAZIONE NON RIUSCITA \n"+ e1.getMessage();
			e1.printStackTrace();
		}
		
		
	}
	
	@Command("redireziona")
	public void redireziona(){
		try {
			String url = EnvironmentUtils.getServerUrl();
			Executions.sendRedirect(url);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	


	
}
