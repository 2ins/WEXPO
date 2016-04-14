package it.wexpo.dao;

import it.wexpo.beans.FeedbackBigBean;

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


}