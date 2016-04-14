package it.wexpo.admin.vm;


import java.sql.SQLException;
import java.util.ArrayList;

import it.wexpo.bean.compo.OperaImmagineBean;
import it.wexpo.bean.compo.UserImmagineBean;
import it.wexpo.beans.ActiveBean;
import it.wexpo.beans.FeedbackBigBean;
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

public class FeedbackVm  {
	
	private ArrayList<FeedbackBigBean> list;
	private FeedbackBigBean ricerca = new FeedbackBigBean();
	private ArrayList<ActiveBean> stati;
	
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
			ArrayList<FeedbackBigBean> modificati = new ArrayList<FeedbackBigBean>();
			for(FeedbackBigBean op:list){
				if (op.isUpdate()){
					modificati.add(op);
				}
			}
			BusinessAdmin.aggiornaFeedback(modificati);
			cerca();
		} catch (SQLException e) {
			Messagebox.show("errore database");
		}
	}
	
	
	@Command
	public void updateRow(@BindingParam("par") FeedbackBigBean bean){
		try {
			updateViewOk(bean);
		} catch (Exception e) {
			e.printStackTrace();
			Messagebox.show("errore database");
		}
	}

	private void updateViewOk(FeedbackBigBean bean) {
		bean.setUpdate(true);
		bean.setAutomation_color("green");
		BindUtils.postNotifyChange(null, null, bean, "*");
	}
	
	
	
	

	
	
	
	
	public ArrayList<FeedbackBigBean> getList() {
		return list;
	}

	public void setList(ArrayList<FeedbackBigBean> list) {
		this.list = list;
	}

	public FeedbackBigBean getRicerca() {
		return ricerca;
	}

	public void setRicerca(FeedbackBigBean ricerca) {
		this.ricerca = ricerca;
	}

	public String getImageWeb(String hash){
		return WexpoMediaUtils.getPathWebFolder(hash);
	}
	
	
	public ArrayList<ActiveBean> getStati() {
		return stati;
	}

	public void setStati(ArrayList<ActiveBean> stati) {
		this.stati = stati;
	}

	
	
	
	
}