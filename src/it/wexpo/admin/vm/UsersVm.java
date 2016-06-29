package it.wexpo.admin.vm;

import java.sql.SQLException;
import java.util.ArrayList;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.Messagebox;

import it.wexpo.autodao.UsersAutoDao;
import it.wexpo.bean.compo.UserImmagineBean;
import it.wexpo.beans.ActiveBean;
import it.wexpo.beans.RuoliBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.business.BusinessAdmin;
import it.wexpo.utils.RuoliSingleton;
import it.wexpo.utils.WexpoMediaUtils;

//info test

public class UsersVm {

	private UsersBean ricerca = new UsersBean();
	private ArrayList<UserImmagineBean> list;
	private ArrayList<RuoliBean> ruoli;
	private ArrayList<ActiveBean> stati;
	
	@Command
	@Init
	@NotifyChange("*")
	public void init(){
		try {
			ruoli = RuoliSingleton.getInstance().getRuoli();
			stati = RuoliSingleton.getStatiDomainAdminUsers();
			list = BusinessAdmin.cerca(ricerca);
		} catch (Exception e) {
			Messagebox.show("errore database");
		}
	}
	
	@Command
	@NotifyChange("*")
	public void salva(){
		try {
			ArrayList<UsersBean> modificati = new ArrayList<UsersBean>();
			for(UserImmagineBean user:list){
				if (user.getUser().isUpdate()){
					modificati.add(user.getUser());
				}
			}
			BusinessAdmin.aggiornaUtenti(modificati);
			cerca();
		} catch (SQLException e) {
			Messagebox.show("errore database");
		}
	}
	
	@Command
	public void openUtente(){
		try {
			
		} catch (Exception e) {
			Messagebox.show("errore database");
		}
	}
	
	
	@Command
	@NotifyChange("*")
	public void cerca(){
		try {
			list = BusinessAdmin.cerca(ricerca);
		} catch (SQLException e) {
			Messagebox.show("errore database");
		}
	}
	
	@Command
	public void updateRowRuolo(@BindingParam("par") UserImmagineBean bean){
		try {
			bean.getUser().setUserIdRuolo(bean.getUser().getRuolo().getRuoloId());
			updateViewOk(bean);
		} catch (Exception e) {
			e.printStackTrace();
			Messagebox.show("errore database");
		}
	}
	
	@Command
	public void updateRow(@BindingParam("par") UserImmagineBean bean){
		try {
			updateViewOk(bean);
		} catch (Exception e) {
			e.printStackTrace();
			Messagebox.show("errore database");
		}
	}

	private void updateViewOk(UserImmagineBean bean) {
		bean.getUser().setUpdate(true);
		bean.getUser().setAutomation_color("green");
		BindUtils.postNotifyChange(null, null, bean, "*");
	}
	
	
	@Command
	public void attiva(@BindingParam("par") UserImmagineBean bean){
		try {
			bean.getUser().setUserActive(1);
			updateViewOk(bean);
			//BusinessAdmin.aggionraUser(bean.getUser());
			BindUtils.postNotifyChange(null, null, bean, "*");
		} catch (Exception e) {
			e.printStackTrace();
			Messagebox.show("errore database");
		}
	}
	
	@Command
	public void disattiva(@BindingParam("par") UserImmagineBean bean){
		try {
			bean.getUser().setUserActive(0);
			updateViewOk(bean);
			//BusinessAdmin.aggionraUser(bean.getUser());
			BindUtils.postNotifyChange(null, null, bean, "*");
		} catch (Exception e) {
			Messagebox.show("errore database");
		}
	}
	
	public boolean isActive(UserImmagineBean bean){
		if (bean.getUser().getUserActive()==0)
			return true;
		return false;
	}
	
	public String getImageWeb(String hash){
		return WexpoMediaUtils.getPathWebFolder(hash);
	}
	
	public UsersBean getRicerca() {
		return ricerca;
	}
	public void setRicerca(UsersBean ricerca) {
		this.ricerca = ricerca;
	}

	public ArrayList<UserImmagineBean> getList() {
		return list;
	}

	public void setList(ArrayList<UserImmagineBean> list) {
		this.list = list;
	}

	public ArrayList<RuoliBean> getRuoli() {
		return ruoli;
	}

	public void setRuoli(ArrayList<RuoliBean> ruoli) {
		this.ruoli = ruoli;
	}

	public ArrayList<ActiveBean> getStati() {
		return stati;
	}

	public void setStati(ArrayList<ActiveBean> stati) {
		this.stati = stati;
	}

	
	
	
}
