package it.wexpo.vm;

import it.wexpo.beans.ImgCloudBean;
import it.wexpo.beans.ImmaginiBean;
import it.wexpo.beans.OpereBean;
import it.wexpo.beans.RuoliBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.business.Business;
import it.wexpo.business.BusinessDao;
import it.wexpo.utils.ApplicationUtils;
import it.wexpo.utils.WexpoMediaUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;

public class OperaVm {
	
	private UsersBean user;
	private ImmaginiBean immagine;	
	private OpereBean opera;
	private boolean salvaDisabled = true;
	
	
	@Init
	@NotifyChange("*")
	public void init(){
		immagine = new ImmaginiBean();
		user = ApplicationUtils.getLoggedUser();
		opera = new OpereBean();
	}
	
	public String getImage(){
		if(immagine.getImmagineHash()!=null){
			String hash = immagine.getImmagineHash();
			return WexpoMediaUtils.getPathWebFolder(hash);
		}
		return null;
	}
	

	
	@Command("onUploadFoto")
	@NotifyChange("*")
	public void onUploadFoto(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx)  throws Exception {
	   
		ImgCloudBean cloudB = WexpoMediaUtils.salvaMediaCloud(ctx,"FOTO");
		immagine.setImmagineHash(cloudB.getId()+"."+cloudB.getFormat());
		immagine.setFormat(cloudB.getFormat());
		refreshButtonSalvaDisabled();
		
   }
	
	
	@Command("refresh")
	@NotifyChange("*")
	public void refresh()  throws IOException {
		refreshButtonSalvaDisabled();
	}

	private void refreshButtonSalvaDisabled() {
		if (opera.getOperaDescrizione()!=null&&!opera.getOperaDescrizione().trim().equals("")&&
				opera.getOperaTitolo()!=null&&!opera.getOperaTitolo().trim().equals("")&&
				immagine.getImmagineHash()!=null){
			salvaDisabled=false;
		}else{
			salvaDisabled=true;
		}
	}
	
	@Command("salva")
	@NotifyChange("*")
	public void salva()  throws IOException {
		try {
			Long x = BusinessDao.salvaOpera(opera,immagine,user);
			System.out.println(x.longValue());
			ApplicationUtils.setSelectedUser(user);
			Executions.sendRedirect("user_dettaglio.zul");
		} catch (SQLException e) {
			Messagebox.show("errore durante inserimento");
		}
	}

	public UsersBean getUser() {
		return user;
	}

	public void setUser(UsersBean user) {
		this.user = user;
	}

	public ImmaginiBean getImmagine() {
		return immagine;
	}

	public void setImmagine(ImmaginiBean immagine) {
		this.immagine = immagine;
	}

	public OpereBean getOpera() {
		return opera;
	}

	public void setOpera(OpereBean opera) {
		this.opera = opera;
	}

	public boolean isSalvaDisabled() {
		return salvaDisabled;
	}

	public void setSalvaDisabled(boolean salvaDisabled) {
		this.salvaDisabled = salvaDisabled;
	}

	
	
	
}
