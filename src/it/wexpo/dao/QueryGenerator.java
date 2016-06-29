package it.wexpo.dao;

import it.wexpo.beans.FeedbackBigBean;
import it.wexpo.beans.RicercaOperaBean;
import it.wexpo.beans.UsersBean;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.zkoss.zk.ui.Executions;


public class QueryGenerator {
	
	private static StringTemplateGroup group;
	private static QueryGenerator instance;
	
	private QueryGenerator(){
		//instance = new QueryGenerator();
		String path = Executions.getCurrent().getDesktop().getWebApp().getRealPath("sql");
		group = new StringTemplateGroup("myGroup", path);
	}
	

	
	public static QueryGenerator getInstance(){
		if (instance==null){
			instance = new QueryGenerator();
		}
		return instance;
	} 
	
	public StringTemplate getTemplate(String fileName){
		StringTemplate tmp = group.getInstanceOf(fileName);
		return tmp;
	}
	
	
	public String getFeedback(FeedbackBigBean cerca){
		
		StringTemplate tmp = getTemplate("feedback");
		
		tmp.setAttribute("userOperaId", cerca.getUserOperaId());
		tmp.setAttribute("userFeedbackId", cerca.getUserFeedbackId());
		tmp.setAttribute("feedbackDescrizione", cerca.getFeedbackDescrizione());
		tmp.setAttribute("feedbackVoto", cerca.getFeedbackVoto());
		tmp.setAttribute("feedbackIdOpera", cerca.getFeedbackIdOpera());
		tmp.setAttribute("operaActive", cerca.getOperaActive());
		
		return tmp.toString();
		
	}
	
public String getOperaSql(int type, String ricerca){
		StringTemplate tmp;
		if (type==0){
			 tmp = getTemplate("opereAll");
			 tmp.setAttribute("ricerca", ricerca);
		}else{
			 tmp = getTemplate("opereTipoFeed");
			 tmp.setAttribute("tipo", type);
			 tmp.setAttribute("ricerca", ricerca);
		}
		
		return tmp.toString();
		
	}

public String getOperaRicercaSql(RicercaOperaBean bean){
	 
	 StringTemplate tmp;
	
	 tmp = getTemplate("ricercaOpere");
	 
	 tmp.setAttribute("nome", bean.getUtenteNome());
	 tmp.setAttribute("cognome", bean.getUtenteCognome());
	 tmp.setAttribute("tag", bean.getTag());
	 tmp.setAttribute("citta", bean.getCitta());
	 tmp.setAttribute("nazione", bean.getNazione());
	 
	 tmp.setAttribute("operaNome", bean.getOperaNome());
	 tmp.setAttribute("operaDescrizione", bean.getOperaDescrizione());
	 
	 tmp.setAttribute("operaNomeEng", bean.getOperaNomeEng());
	 tmp.setAttribute("operaDescrizioneEng", bean.getOperaDescrizioneEng());
	
	return tmp.toString();
	
}

public String getOperaUser(Long userId){
	StringTemplate tmp;
	
	tmp = getTemplate("opereByUser");
	tmp.setAttribute("userId", userId);
	
	return tmp.toString();	
}

public String getFeedbackEmessi(Long userId){
	StringTemplate tmp;
	
	tmp = getTemplate("feedbackEmessiByUser");
	tmp.setAttribute("userId", userId);
	
	return tmp.toString();	
}

public String getUtenti(UsersBean user){
	StringTemplate tmp;
	
	tmp = getTemplate("cercaUtenti");
	
	tmp.setAttribute("nome", getNullValueisEmptyString(user.getUserNome()));
	tmp.setAttribute("cognome", getNullValueisEmptyString(user.getUserCognome()));
	tmp.setAttribute("citta", getNullValueisEmptyString(user.getUserCitta()));
	tmp.setAttribute("nazione", getNullValueisEmptyString(user.getUserNazione()));
	
	return tmp.toString();	
}

	public String getFeedbackCritOpera(Long operaId){
		StringTemplate tmp;
		tmp = getTemplate("feedbackCritOpera");
		tmp.setAttribute("opera_id", operaId);
		return tmp.toString();	
	}

	public String getFeedbackPopOpera(Long operaId){
		StringTemplate tmp;
		tmp = getTemplate("feedbackPopOpera");
		tmp.setAttribute("opera_id", operaId);
		return tmp.toString();	
	}
	
	
	public String getNullValueisEmptyString(String str){
		if (str == null) 
			return null;
		else if(str.trim().equalsIgnoreCase(""))
			return null;
		else return str;
		
	}
}