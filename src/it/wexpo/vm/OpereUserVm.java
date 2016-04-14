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
import it.wexpo.beans.UsersBean;
import it.wexpo.business.BusinessDao;
import it.wexpo.business.BusinessOpere;
import it.wexpo.utils.ApplicationUtils;

public class OpereUserVm extends OpereGenericVm{
	
	private UsersBean utenteSelected;
	private ArrayList<OperaViewBean> opere = new ArrayList<OperaViewBean>();
	private InfoGlobalOpereViewBean infoGlobal;
	
	@Init
	@NotifyChange("*")
	public void init()  throws IOException {
		
		try {
			utenteSelected = ApplicationUtils.getSelectedUser();
			if(utenteSelected==null){
				Messagebox.show("nessun utente selezionato");
				Executions.getCurrent().sendRedirect("index.zul");
			}
			
			opere = BusinessOpere.cercaOpereEspositore(utenteSelected);
			infoGlobal = valorizzaInfoGlobal();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	private InfoGlobalOpereViewBean valorizzaInfoGlobal() {
		
		InfoGlobalOpereViewBean infoGlobal = new InfoGlobalOpereViewBean();
		
		int crit = 0;
		int pop = 0;
		int popFeeds = 0;
		int critFeeds = 0;
		
		for (OperaViewBean o:opere){
			crit += o.getOperaRateCrit();
			critFeeds += o.getOperaRateCritFeeds();
			pop = o.getOperaRatePop();
			popFeeds += o.getOperaRatePopFeeds();
		}
		
		infoGlobal.setOperaRateCrit(crit);
		infoGlobal.setOperaRateCritFeeds(critFeeds);
		infoGlobal.setOperaRatePop(pop);
		infoGlobal.setOperaRatePopFeeds(popFeeds);
		
		return infoGlobal;
		
	}

	public ArrayList<OperaViewBean> getOpere() {
		return opere;
	}
	public void setOpere(ArrayList<OperaViewBean> opere) {
		this.opere = opere;
	}

	public UsersBean getUtenteSelected() {
		return utenteSelected;
	}

	public void setUtenteSelected(UsersBean utenteSelected) {
		this.utenteSelected = utenteSelected;
	}

	public InfoGlobalOpereViewBean getInfoGlobal() {
		return infoGlobal;
	}

	public void setInfoGlobal(InfoGlobalOpereViewBean infoGlobal) {
		this.infoGlobal = infoGlobal;
	}

	
}
