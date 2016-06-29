package it.wexpo.vm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import it.test.cloud.Test;
import it.wexpo.beans.OperaViewBean;
import it.wexpo.business.BusinessOpere;

public class OpereAllVm extends OpereGenericVm{
	
	private ArrayList<OperaViewBean> opere = new ArrayList<OperaViewBean>();
	
	@Init
	@NotifyChange("*")
	public void init()  throws IOException {
		try {
			opere = BusinessOpere.cercaOpere(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	public ArrayList<OperaViewBean> getOpere() {
		return opere;
	}
	
	public void setOpere(ArrayList<OperaViewBean> opere) {
		this.opere = opere;
	}
	
}
