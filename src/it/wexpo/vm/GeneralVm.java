package it.wexpo.vm;

import it.wexpo.utils.ApplicationUtils;

public class GeneralVm {

	public boolean isUserLogged(){
		return (ApplicationUtils.getLoggedUser()!=null);
	}
	
}
