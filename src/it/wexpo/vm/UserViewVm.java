package it.wexpo.vm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;

import it.wexpo.beans.InfoGlobalOpereViewBean;
import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.UserViewBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.business.BusinessDao;
import it.wexpo.business.BusinessOpere;
import it.wexpo.business.BusinessUtente;
import it.wexpo.utils.ApplicationUtils;
import it.wexpo.utils.WexpoMediaUtils;

public class UserViewVm extends GeneralVm{
	
	private UsersBean utenteSelected;
	private UserViewBean user;
	
	
	@Init
	@NotifyChange("*")
	public void init()  throws IOException {
		
		try {
			utenteSelected = ApplicationUtils.getSelectedUser();
			
			if(utenteSelected==null){
				Messagebox.show("nessun utente selezionato");
				Executions.getCurrent().sendRedirect("index.zul");
				
			}
			
			user = BusinessUtente.findView(utenteSelected);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public String getImageLink(){
		return WexpoMediaUtils.getImage(user.getUserImmagine());
	}

	public UsersBean getUtenteSelected() {
		return utenteSelected;
	}

	public void setUtenteSelected(UsersBean utenteSelected) {
		this.utenteSelected = utenteSelected;
	}

	public UserViewBean getUser() {
		return user;
	}

	public void setUser(UserViewBean user) {
		this.user = user;
	}

	
	
}
