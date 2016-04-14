package it.wexpo.beans;

import it.wexpo.utils.WexpoMediaUtils;

import java.util.ArrayList;

import automation.bean.AutomationBean;

public abstract class ViewBean extends AutomationBean {
	
	private Integer operaRatePop;
	private Integer operaRateCrit;
	private Integer operaRatePopFeeds;
	private Integer operaRateCritFeeds;
	
	
	
	
	public Float getMediaPopValue(){
		if (operaRatePop!=null && operaRatePopFeeds!=null && operaRatePopFeeds>0)
			return (float)operaRatePop/operaRatePopFeeds;
		return null;
	}
	
	public Float getMediaCritValue(){
		if (operaRateCrit!=null && operaRateCritFeeds!= null && operaRateCritFeeds>0)
			return (float)operaRateCrit/operaRateCritFeeds;
		return null;
	}
	
	public ArrayList<Integer> getMediaPopImg(){
		Float aux = getMediaPopValue();
		if (aux==null)
			return null;
		Float x = aux/2;
		return WexpoMediaUtils.getRateAsIntegerArray(x);
	}

	
	
	public ArrayList<Integer> getMediaCritImg(){

		Float aux = getMediaCritValue();
		if (aux==null)
			return null;
		Float x = aux/2;
		return WexpoMediaUtils.getRateAsIntegerArray(x);
	}
	
	
	
	
	
	

	public Integer getOperaRatePop() {
		return operaRatePop;
	}

	public void setOperaRatePop(Integer operaRatePop) {
		this.operaRatePop = operaRatePop;
	}

	public Integer getOperaRateCrit() {
		return operaRateCrit;
	}

	public void setOperaRateCrit(Integer operaRateCrit) {
		this.operaRateCrit = operaRateCrit;
	}

	public Integer getOperaRatePopFeeds() {
		return operaRatePopFeeds;
	}

	public void setOperaRatePopFeeds(Integer operaRatePopFeeds) {
		this.operaRatePopFeeds = operaRatePopFeeds;
	}

	public Integer getOperaRateCritFeeds() {
		return operaRateCritFeeds;
	}

	public void setOperaRateCritFeeds(Integer operaRateCritFeeds) {
		this.operaRateCritFeeds = operaRateCritFeeds;
	}
	
	
}
