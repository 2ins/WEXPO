package it.wexpo.vm;

import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.TagBean;
import it.wexpo.business.BusinessTag;
import it.wexpo.utils.ApplicationUtils;

import java.sql.SQLException;
import java.util.ArrayList;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.annotation.Init;



public class TagVm extends GeneralVm{
	
	private OperaViewBean operaView;
	private ArrayList<TagBean> operaTagList;
	private TagBean bean = new TagBean();
	private TagBean cerca = new TagBean();
	
	@NotifyChange("*")
	@Init
	public void Init(){
		
		try {
			operaView = ApplicationUtils.getOperaSelected();
			cerca.setTagOperaId(operaView.getOperaId());
			operaTagList = BusinessTag.caricaTag(cerca);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	@NotifyChange("operaTagList")
	@Command("eliminaTag")
	public void eliminaTag(@BindingParam("par") TagBean current){
		
		try {
			operaTagList.remove(current);
			BusinessTag.eliminaTag(current);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	 
	
	@NotifyChange("*")
	@Command("cerca")
	public void cerca(){
		
		try {
			operaTagList = BusinessTag.caricaTag(cerca);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	
	@NotifyChange("*")
	@Command("salva")
	public void salva(){
	
		try {
			bean.setTagOperaId(cerca.getTagOperaId());
			BusinessTag.salvaTag(bean);
			operaTagList = BusinessTag.caricaTag(cerca);
			bean = new TagBean();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean evaluateTagEnabled(){
		if (super.isUserLogged()){
			Long id = ApplicationUtils.getLoggedUser().getUserId();
			if (operaView.getUserId().equals(id)){
				return true;
			}
		} 
		return false;
	}


	public TagBean getBean() {
		return bean;
	}



	public void setBean(TagBean bean) {
		this.bean = bean;
	}



	public TagBean getCerca() {
		return cerca;
	}



	public void setCerca(TagBean cerca) {
		this.cerca = cerca;
	}


	public ArrayList<TagBean> getOperaTagList() {
		return operaTagList;
	}


	public void setOperaTagList(ArrayList<TagBean> operaTagList) {
		this.operaTagList = operaTagList;
	}
	
	
	
	
}
