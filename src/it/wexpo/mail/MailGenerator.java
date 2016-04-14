package it.wexpo.mail;

import it.wexpo.beans.FeedbackBigBean;
import it.wexpo.beans.UsersBean;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.zkoss.zk.ui.Executions;


public class MailGenerator {
	
	private static StringTemplateGroup group;
	private static MailGenerator instance;
	
	private MailGenerator(){
		//instance = new QueryGenerator();
		String path = Executions.getCurrent().getDesktop().getWebApp().getRealPath("mail");
		group = new StringTemplateGroup("myGroupMail", path);
	}
	

	
	public static MailGenerator getInstance(){
		if (instance==null){
			instance = new MailGenerator();
		}
		return instance;
	} 
	
	public StringTemplate getTemplate(String fileName){
		StringTemplate tmp = group.getInstanceOf(fileName);
		return tmp;
	}
	
	
	public String getBenvenuto(UsersBean user, String token){
		
		StringTemplate tmp = getTemplate("conferma_mail");
		
		tmp.setAttribute("nome", user.getUserNome());
		tmp.setAttribute("cognome", user.getUserCognome());
		String link = "http://localhost:8080/WEXPO_MANHATTA/auth/auth.zul?token="+token;
		tmp.setAttribute("link", link);
		
		return tmp.toString();
		
	}
	
public String getPasswDimenticata(UsersBean user, String token){
		
		StringTemplate tmp = getTemplate("conferma_mail");
		
		tmp.setAttribute("nome", user.getUserNome());
		tmp.setAttribute("cognome", user.getUserCognome());
		String link = "http://localhost:8080/WEXPO_MANHATTA/auth/resetPassword.zul?token="+token;
		tmp.setAttribute("link", link);
		
		return tmp.toString();
		
	}


}