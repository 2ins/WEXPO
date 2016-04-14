package it.wexpo.admin.vm;


import java.sql.SQLException;
import java.util.ArrayList;

import it.wexpo.bean.compo.OperaImmagineBean;
import it.wexpo.bean.compo.UserImmagineBean;
import it.wexpo.beans.ActiveBean;
import it.wexpo.beans.OpereBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.business.BusinessAdmin;
import it.wexpo.utils.RuoliSingleton;
import it.wexpo.utils.WexpoMediaUtils;
import it.zone.vm.AbstractCrudVM;
import it.zone.business.AbstractBusiness;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;

public class OpereVm  {
	
	private ArrayList<OperaImmagineBean> list;
	private OpereBean ricerca = new OpereBean();
	private ArrayList<ActiveBean> stati;
	
	
	
	public Float getMediaPopValue(OpereBean o){
		if (o.getOperaRatePop()!=null && o.getOperaRatePopFeeds()!=null && o.getOperaRatePopFeeds()>0)
			return (float)o.getOperaRatePop()/o.getOperaRatePopFeeds();
		return null;
	}
	
	public Float getMediaCritValue(OpereBean o){
		if (o.getOperaRateCrit()!=null && o.getOperaRateCritFeeds()!= null && o.getOperaRateCritFeeds()>0)
			return (float)o.getOperaRateCrit()/o.getOperaRateCritFeeds();
		return null;
	}
	
	@Init
	@Command
	@NotifyChange({"*"})
	public void init(){  
		try {
			list = BusinessAdmin.cerca(ricerca);
			stati = RuoliSingleton.getInstance().getStati();
		} catch (Exception e) {
			Messagebox.show("errore database");
		}
	}
	
	@Command
	@NotifyChange({"*"})
	public void cerca(){
		try {
			list = BusinessAdmin.cerca(ricerca);
		} catch (SQLException e) {
			Messagebox.show("errore database");
		}	
	}
	
	@Command
	@NotifyChange("*")
	public void salva(){
		try {
			ArrayList<OpereBean> modificati = new ArrayList<OpereBean>();
			for(OperaImmagineBean op:list){
				if (op.getOpera().isUpdate()){
					modificati.add(op.getOpera());
				}
			}
			BusinessAdmin.aggiornaOpere(modificati);
			cerca();
		} catch (SQLException e) {
			Messagebox.show("errore database");
		}
	}
	
	
	@Command
	public void updateRow(@BindingParam("par") OperaImmagineBean bean){
		try {
			updateViewOk(bean);
		} catch (Exception e) {
			e.printStackTrace();
			Messagebox.show("errore database");
		}
	}

	private void updateViewOk(OperaImmagineBean bean) {
		bean.getOpera().setUpdate(true);
		bean.getOpera().setAutomation_color("green");
		BindUtils.postNotifyChange(null, null, bean, "*");
	}
	
	
	@Command
	public void attiva(@BindingParam("par") OperaImmagineBean bean){
		try {
			bean.getOpera().setOperaActive(1);
			updateViewOk(bean);
			//BusinessAdmin.aggionraUser(bean.getUser());
			BindUtils.postNotifyChange(null, null, bean, "*");
		} catch (Exception e) {
			e.printStackTrace();
			Messagebox.show("errore database");
		}
	}
	
	@Command
	public void disattiva(@BindingParam("par") OperaImmagineBean bean){
		try {
			bean.getOpera().setOperaActive(0);
			updateViewOk(bean);
			//BusinessAdmin.aggionraUser(bean.getUser());
			BindUtils.postNotifyChange(null, null, bean, "*");
		} catch (Exception e) {
			Messagebox.show("errore database");
		}
	}
	

	
	
	
	
	public String getImageWeb(String hash){
		return WexpoMediaUtils.getPathWebFolder(hash);
	}
	
	public ArrayList<OperaImmagineBean> getList() {
		return list;
	}

	public void setList(ArrayList<OperaImmagineBean> list) {
		this.list = list;
	}

	public OpereBean getRicerca() {
		return ricerca;
	}

	public void setRicerca(OpereBean ricerca) {
		this.ricerca = ricerca;
	}

	public ArrayList<ActiveBean> getStati() {
		return stati;
	}

	public void setStati(ArrayList<ActiveBean> stati) {
		this.stati = stati;
	}

	
	
	
	
}