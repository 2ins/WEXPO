package it.wexpo.vm;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.UserViewBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.business.BusinessAdmin;
import it.wexpo.business.BusinessUtente;
import it.wexpo.dao.DaoUtils;
import it.wexpo.dao.UsersDao;
import it.wexpo.utils.ApplicationUtils;
import it.wexpo.utils.WexpoMediaUtils;
import it.zone.vm.AbstractCrudVM;
import it.zone.business.AbstractBusiness;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;

public class UsersVm {
	
	private ArrayList<UserViewBean> list = new ArrayList<UserViewBean>();
	private UsersBean user = new UsersBean();
	
	@Init
	@Command
	@NotifyChange({"*"})
	public void init(){
		
		
	}
	@Command("apriDettaglioUtente")
	@NotifyChange("*")
	public void apriDettaglioUtente(@BindingParam("par") UserViewBean ub)  throws IOException {
		try {
			UsersBean b = new UsersBean();
			b.setUserId(ub.getUserId());
			ApplicationUtils.setSelectedUser(b);
			Executions.sendRedirect("/user_dettaglio.zul");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	public String getImageLink(UserViewBean vb){
		String hash = vb.getUserImmagine();
		return WexpoMediaUtils.getImage(hash);
	}
	
	@Command
	@NotifyChange({"*"})
	public void ricerca(){
		
		try {
			
			list = BusinessUtente.ricercaView(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public ArrayList<UserViewBean> getList() {
		return list;
	}


	public void setList(ArrayList<UserViewBean> list) {
		this.list = list;
	}
	
	
	public UsersBean getUser() {
		return user;
	}
	
	public void setUser(UsersBean user) {
		this.user = user;
	}




	
}