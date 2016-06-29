package it.wexpo.vm;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.SelectorParam;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;

public class AccettaTerminiVm {
	
	protected boolean accetta = false;

	
	@Init
	public void init(){
		
	}
	
	@Command
	public void accetta(){
		Window window = (Window)Executions.createComponents("/accetta.zul", null, null);
		window.setClosable(true);   
		window.doModal();

	}

	@Command
	public void accettaOk(@SelectorParam("#win") Window window) {
		window.onClose();
		BindUtils.postGlobalCommand(null, null, "salvaRegister", null);
	}

	
	public boolean isAccetta() {
		return accetta;
	}

	public void setAccetta(boolean accetta) {
		this.accetta = accetta;
	}
	
	
	
}
