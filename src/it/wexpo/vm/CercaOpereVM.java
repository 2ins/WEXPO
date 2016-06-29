package it.wexpo.vm;

import it.wexpo.beans.FeedbackBean;
import it.wexpo.beans.ImmaginiBean;
import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.OpereBean;
import it.wexpo.beans.RicercaOperaBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.business.BusinessDao;
import it.wexpo.business.BusinessOpere;
import it.wexpo.business.FeedbackBusiness;
import it.wexpo.dao.OpereDao;
import it.wexpo.utils.ApplicationUtils;
import it.wexpo.utils.WexpoMediaUtils;

import java.sql.SQLException;
import java.util.ArrayList;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;

public class CercaOpereVM extends GeneralVm{
	
	private ArrayList<OperaViewBean> opere ;
	private RicercaOperaBean ricerca = new RicercaOperaBean();
	

	
	@Init
	@NotifyChange("*")
	public void init(){
	  
	}
	
	
	@NotifyChange("*")
	@Command("cerca")
	public void cerca(){
		try {
			System.out.println("cerca");
			opere =BusinessOpere.cercaOpereNome(ricerca);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Messagebox.show("errore database");
			e.printStackTrace();
		}
	}
	
	
	@Command("apriDettaglioUtente")
	public void apriDettaglioUtente(@BindingParam("par") OperaViewBean operaViewBean){
		try {
			UsersBean b = new UsersBean();
			b.setUserId(operaViewBean.getUserId());
			ApplicationUtils.setSelectedUser(b);
			Executions.sendRedirect("/user_dettaglio.zul");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Messagebox.show("errore database");
			e.printStackTrace();
		}
	}
	
	@Command("apriDettaglioOpera")
	public void apriDettaglioOpera(@BindingParam("par") OperaViewBean operaViewBean){
		try {
			ApplicationUtils.setOperaSelected(operaViewBean);
			Executions.sendRedirect("/feedback.zul");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Messagebox.show("errore database");
			e.printStackTrace();
		}
	}

	
	public String getImageLink(OperaViewBean op){
		String hash = op.getImmagineHash();
		return WexpoMediaUtils.getImage(hash);
	}

	public ArrayList<OperaViewBean> getOpere() {
		return opere;
	}


	public void setOpere(ArrayList<OperaViewBean> opere) {
		this.opere = opere;
	}


	public RicercaOperaBean getRicerca() {
		return ricerca;
	}


	public void setRicerca(RicercaOperaBean ricerca) {
		this.ricerca = ricerca;
	}


	
		
		
}
