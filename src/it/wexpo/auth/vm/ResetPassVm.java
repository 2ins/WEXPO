package it.wexpo.auth.vm;

import it.wexpo.beans.UsersBean;
import it.wexpo.business.BusinessAuth;
import it.wexpo.business.BusinessLogin;
import it.wexpo.utils.ApplicationUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Messagebox;

public class ResetPassVm {
	
	private String status;
	private boolean ok=false;
	private boolean salvaDisabled=true;
	private boolean redirectOk = false;
	private String p1;
	private String p2;
	private String token;
	private UsersBean user;
	
	
	@Init
	@NotifyChange("*")
	public void init(){
		
		Execution e = Executions.getCurrent();
		HttpServletRequest request = (HttpServletRequest) e.getNativeRequest();
		token  = request.getParameter("token");
        
		try {
			
			user = BusinessAuth.ExecuteAuth(token,false);
			status = "Complimenti autenticazione riuscita reinserisci password";
			ok=true;
			
		} catch (Exception e1) {
			status = "AUTENTICAZIONE NON RIUSCITA \n"+ e1.getMessage();
			e1.printStackTrace();
		}
		
		
	}
	
	
	@Command("refresh")
	@NotifyChange("*")
	public void refresh()  throws IOException {
		
		if (p1!=null&&p2!=null) {
			salvaDisabled=false;
		}else{
			salvaDisabled=true;
		}
	}
	
	@Command("salva")
	@NotifyChange("*")
	public void salva()  throws IOException {
		
		try {
			BusinessAuth.ChangePasswordDleteAuthLogUser(p1,token,user);
			status = "Password cambiata correttamente";
			ok=false;
			redirectOk=true;
			Thread.sleep(4000);
			redireziona();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
		
	
	@Command("redireziona")
	public void redireziona(){
		Executions.sendRedirect("index.zul");
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}


	public boolean isSalvaDisabled() {
		return salvaDisabled;
	}


	public void setSalvaDisabled(boolean salvaDisabled) {
		this.salvaDisabled = salvaDisabled;
	}


	public String getP1() {
		return p1;
	}


	public void setP1(String p1) {
		this.p1 = p1;
	}


	public String getP2() {
		return p2;
	}


	public void setP2(String p2) {
		this.p2 = p2;
	}


	public boolean isRedirectOk() {
		return redirectOk;
	}


	public void setRedirectOk(boolean redirectOk) {
		this.redirectOk = redirectOk;
	}


	public UsersBean getUser() {
		return user;
	}


	public void setUser(UsersBean user) {
		this.user = user;
	}
	
	
	


	
}
