package it.wexpo.beans;

import java.lang.Long;

import automation.bean.AutomationBean;

public class OpereImmaginiBean extends AutomationBean{
	private Long operaImmagineId;
	private Long operaImmagineIdImmagine;
	private Long operaImmagineIdOpera;
	

	public Long getOperaImmagineId()  {
		return this.operaImmagineId;
	}
	public void setOperaImmagineId(Long operaImmagineId) {
		this.operaImmagineId = operaImmagineId;
	}
	public Long getOperaImmagineIdImmagine()  {
		return this.operaImmagineIdImmagine;
	}
	public void setOperaImmagineIdImmagine(Long operaImmagineIdImmagine) {
		this.operaImmagineIdImmagine = operaImmagineIdImmagine;
	}
	public Long getOperaImmagineIdOpera()  {
		return this.operaImmagineIdOpera;
	}
	public void setOperaImmagineIdOpera(Long operaImmagineIdOpera) {
		this.operaImmagineIdOpera = operaImmagineIdOpera;
	}

	@Override
	public AutomationBean getNewInstance() {
		return new OpereImmaginiBean();
	}
	
	
	

}