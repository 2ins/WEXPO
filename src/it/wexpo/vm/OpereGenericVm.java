package it.wexpo.vm;

import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.utils.ApplicationUtils;
import it.wexpo.utils.WexpoMediaUtils;

import java.io.IOException;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;

public class OpereGenericVm extends GeneralVm{
	public String getImageLink(OperaViewBean op){
		return WexpoMediaUtils.getImage(op.getImmagineHash());
	}
	

	public String getTrunk(OperaViewBean op){
		if (isLuanguageIta()){
			return WexpoMediaUtils.getTrunk(op.getOperaDescrizione());
		}else{
			return WexpoMediaUtils.getTrunk(op.getOperaDescrizioneEng());
		}
	}
	
	
	@Command("apriOpera")
	@NotifyChange("*")
	public void apriOpera(@BindingParam("param") OperaViewBean op)  throws IOException {
		try {
			ApplicationUtils.setOperaSelected(op);
			Executions.sendRedirect("/feedback.zul");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	@Command("openLink")
	public void openLink(@BindingParam("par") String op)  throws IOException {
		try {
			System.out.println("site: "+op);
			if (!op.toLowerCase().contains("http://")&&!op.toLowerCase().contains("https://")){
				op = "http://"+op;
			}
			Executions.getCurrent().sendRedirect(op, "_blank");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	@Command("apriUtente")
	@NotifyChange("*")
	public void apriUtente(@BindingParam("param") OperaViewBean op)  throws IOException {
		try {
			UsersBean b = new UsersBean();
			b.setUserId(op.getUserId());
			ApplicationUtils.setSelectedUser(b);
			Executions.sendRedirect("/user_dettaglio.zul");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
