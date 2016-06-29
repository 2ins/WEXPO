package it.wexpo.vm;

import it.wexpo.utils.ApplicationUtils;

public class GeneralVm {

	public boolean isUserLogged(){
		return (ApplicationUtils.getLoggedUser()!=null);
	}
	
	public boolean isLuanguageIta(){
		String language = ApplicationUtils.getLanguageEnv();
		if (language.equalsIgnoreCase("it")){
			return true;
		}
		return false;
	}
	
}
