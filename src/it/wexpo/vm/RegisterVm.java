package it.wexpo.vm;

import it.wexpo.auth.BusinessAutenticazione;
import it.wexpo.beans.ImgCloudBean;
import it.wexpo.beans.ImmaginiBean;
import it.wexpo.beans.RuoliBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.business.Business;
import it.wexpo.business.BusinessDao;
import it.wexpo.business.BusinessLogin;
import it.wexpo.mail.MailProcessor;
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

public class RegisterVm {

	private UsersBean user;
	private ImmaginiBean immagine;	
	private String re_password = null;
	private ArrayList<RuoliBean> ruoli;
	private RuoliBean ruoloSelected;
	private boolean salvaDisabled = true;
	
	@Init
	@NotifyChange("*")
	public void init(){
		user = new UsersBean();
		UsersBean logged = ApplicationUtils.getLoggedUser();
		if (logged!=null){
			user = logged;
			//ruoloSelected = ruoli.get(user.getUserIdRuolo());
		}
		immagine = new ImmaginiBean();
		ruoli = Business.popolaRuoli();
		ruoloSelected=ruoli.get(0);
	}


	
	@Command("salva")
	@NotifyChange("*")
	public void salva()  throws IOException {
		try {
			if (!re_password.equals(user.getUserPassword())){
				Messagebox.show("password non coincidenti");
				return;
			}
			
			if (user.getUserId()==null){
				if (BusinessDao.getUtenteEmailEsistente(user)){
					Messagebox.show("utente gia registrato con questa mail");
					return;
				}
			}
			
			
			user.setUserIdRuolo(ruoloSelected.getRuoloId());
			
			
			BusinessLogin.salvaUtenteAutenticaInviaMailTransational(user,immagine);
			
			
			
			
			Messagebox.show("aggiornamento avvenuto con successo."+
			"Controlla la tuo casella di posta ed inizia a navigare su WEXPO! ");
			
			//ApplicationUtils.setLoggedUser(user);
			
			 try {
				Thread.sleep(4000);
				Executions.sendRedirect("index.zul");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		} catch (SQLException e) {
			Messagebox.show("errore durante inserimento");
		}
	}
	 


	@Command("refresh")
	@NotifyChange("salvaDisabled")
	public void refresh()  throws IOException {
		System.out.println("ciao");
		if (user.getUserNome()!=null && !user.getUserNome().trim().equals("")
				&& user.getUserCognome()!=null && !user.getUserCognome().trim().equals("")
				&& user.getUserPassword()!=null && !user.getUserPassword().trim().equals("")
				&& user.getUserEmail()!=null && !user.getUserEmail().trim().equals("")
				&& this.re_password!=null && !this.re_password.trim().equals("")) {
			salvaDisabled=false;
		}else{
			salvaDisabled=true;
		}
	}
		
		
	
	@Command("onUploadFoto")
	@NotifyChange("*")
	public void onUploadFoto(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx)  throws IOException {
	   
		String idFoto;
		ImgCloudBean cloudB;
		try {
			cloudB = WexpoMediaUtils.salvaMediaCloud(ctx,"FOTO");
			immagine.setImmagineHash(cloudB.getId()+"."+cloudB.getFormat());
			immagine.setFormat(cloudB.getFormat());
		} catch (Exception e) {
			Messagebox.show("probelma in fase di salvataggio");
		}
		
		
		
   }

	
	
	
	@Command("onUploadCv")
	@NotifyChange("*")
	public void onUploadCv(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx)  throws IOException {
	   
		String idCv = WexpoMediaUtils.salvaMedia(ctx,"CV");
   }



	public UsersBean getUser() {
		return user;
	}

	public void setUser(UsersBean user) {
		this.user = user;
	}

	public String getRe_password() {
		return re_password;
	}

	public void setRe_password(String re_password) {
		this.re_password = re_password;
	}



	public ImmaginiBean getImmagine() {
		return immagine;
	}



	public void setImmagine(ImmaginiBean immagine) {
		this.immagine = immagine;
	}



	public ArrayList<RuoliBean> getRuoli() {
		return ruoli;
	}



	public void setRuoli(ArrayList<RuoliBean> ruoli) {
		this.ruoli = ruoli;
	}



	public RuoliBean getRuoloSelected() {
		return ruoloSelected;
	}



	public void setRuoloSelected(RuoliBean ruoloSelected) {
		this.ruoloSelected = ruoloSelected;
	}



	public boolean isSalvaDisabled() {
		return salvaDisabled;
	}



	public void setSalvaDisabled(boolean salvaDisabled) {
		this.salvaDisabled = salvaDisabled;
	}
	
	
	
	
}
