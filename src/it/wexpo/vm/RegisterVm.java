package it.wexpo.vm;

import it.wexpo.auth.BusinessAutenticazione;
import it.wexpo.beans.ImgCloudBean;
import it.wexpo.beans.ImmaginiBean;
import it.wexpo.beans.RuoliBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.business.Business;
import it.wexpo.business.BusinessDao;
import it.wexpo.business.BusinessLogin;
import it.wexpo.business.BusinessUtente;
import it.wexpo.dao.UsersDao;
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
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.io.Files;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

public class RegisterVm {

	private UsersBean user;
	private ImmaginiBean immagine;	
	private ImmaginiBean cv;	
	private String re_password = null;
	private ArrayList<RuoliBean> ruoli;
	private RuoliBean ruoloSelected;
	private boolean salvaDisabled = true;
	
	@Init
	@NotifyChange("*")
	public void init(){
		try {	
			user = new UsersBean();
			ruoli = Business.popolaRuoli();
			
			UsersBean logged = ApplicationUtils.getLoggedUser();
			if (logged!=null){
				user = logged;
				re_password = user.getUserPassword();
				salvaDisabled = false;
				int userRole = user.getUserIdRuolo().intValue();
				userRole = userRole - 1;
				ruoloSelected = ruoli.get(userRole);
				immagine = BusinessUtente.findFoto(user.getUserFoto());
				cv = BusinessUtente.findFoto(user.getUserCv());
			}else{
				immagine = BusinessUtente.findFoto(1);
				
				cv = new ImmaginiBean();
				ruoloSelected=ruoli.get(0);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			Messagebox.show("errore");
		}
	}



	public void conferma(){
		try{
			boolean chk = chekUpSave();
			if(chk==false){
				return;
			}
			
			Window window = (Window)Executions.createComponents("/accettazione.zul", null, null);
			window.setClosable(true);   
			window.doModal();
			
		}catch(Exception e){
		e.printStackTrace();
		}
	}


	private boolean chekUpSave()  {
		if (user.getUserId()==null){
			if (!re_password.equals(user.getUserPassword())){
				Messagebox.show("password non coincidenti");
				return false;
			}
		
			try {
				if (BusinessDao.getUtenteEmailEsistente(user)){
					Messagebox.show("utente gia registrato con questa mail");
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Messagebox.show("errore");
				return false;
			}
		}
		
		return true;
	}
	
	
	
	@Command("salva")
	public void salva() {
		
		 
		boolean chk = chekUpSave();
		if(chk==false){
			return;
		}
		
			
		
		try {
			if (user.getUserId()==null){
				conferma();
			}else{
				salvaRegister();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Messagebox.show("errore");
		}
		
	}
	
	
	@GlobalCommand("salvaRegister")
	@NotifyChange("*")
	public void salvaRegister()  throws IOException {
		try {
			
			
			boolean nuovoCond = (user.getUserId()==null);
			
			user.setUserIdRuolo(ruoloSelected.getRuoloId());
			BusinessLogin.salvaUtenteAutenticaInviaMailTransational(user,immagine,cv);
			
			
			
			
			if (nuovoCond){
				String msg = "aggiornamento avvenuto con successo.";
				msg += "\nControlla la tuo casella di posta ed inizia a navigare su WEXPO!";
				Messagebox.show(msg);
			}
			
			
			
			//ApplicationUtils.setLoggedUser(user);
			
			 try {
				if (nuovoCond){ 
					Thread.sleep(8000);
				}
				Executions.sendRedirect("index.zul");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Messagebox.show("errore");
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Messagebox.show("errore");
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
			immagine = new ImmaginiBean();
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
	   
		String idFoto;
		ImgCloudBean cloudB;
		try {
			cloudB = WexpoMediaUtils.salvaMediaCloud(ctx,"CV");
			cv=new ImmaginiBean();
			cv.setImmagineHash(cloudB.getId()+"."+cloudB.getFormat());
			cv.setFormat(cloudB.getFormat());
			
		} catch (Exception e) {
			Messagebox.show("probelma in fase di salvataggio");
		}
   }
	
	public String getImage(){
		if(immagine.getImmagineHash()!=null){
			String hash = immagine.getImmagineHash();
			return WexpoMediaUtils.getPathWebFolder(hash);
		}
		return null;
	}
	
	@Command("apriCv")
	public void apriCv(){
		if(cv.getImmagineHash()!=null){
			String hash = cv.getImmagineHash();
			hash = hash.split("\\.")[0];
			String webPath = WexpoMediaUtils.getPathWebCvFolder(hash);
			Executions.getCurrent().sendRedirect(webPath, "_blank");
		}
		
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



	public ImmaginiBean getCv() {
		return cv;
	}



	public void setCv(ImmaginiBean cv) {
		this.cv = cv;
	}
	
	
	
	
}
