package it.wexpo.beans;

import java.lang.Long;
import java.lang.String;
import automation.bean.AutomationBean;

public class RuoliBean extends AutomationBean{
	private Long ruoloId;
	private String ruoloDescrizione;

	public Long getRuoloId()  {
		return this.ruoloId;
	}
	public void setRuoloId(Long ruoloId) {
		this.ruoloId = ruoloId;
	}
	public String getRuoloDescrizione()  {
		return this.ruoloDescrizione;
	}
	public void setRuoloDescrizione(String ruoloDescrizione) {
		this.ruoloDescrizione = ruoloDescrizione;
	}

	@Override
	public AutomationBean getNewInstance() {
		return new RuoliBean();
	}

}