package it.wexpo.beans;

import java.lang.Long;
import java.lang.Integer;
import java.lang.String;
import automation.bean.AutomationBean;

public class FeedbackBean extends AutomationBean{
	private Long feedbackId;
	private Integer feedbackVoto;
	private String feedbackDescrizione;
	private Long feedbackIdOpera;
	private Long feedbackIdUser;
	private Integer feedbackTipo;


	public Long getFeedbackId()  {
		return this.feedbackId;
	}
	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}
	public Integer getFeedbackVoto()  {
		return this.feedbackVoto;
	}
	public void setFeedbackVoto(Integer feedbackVoto) {
		this.feedbackVoto = feedbackVoto;
	}
	public String getFeedbackDescrizione()  {
		return this.feedbackDescrizione;
	}
	public void setFeedbackDescrizione(String feedbackDescrizione) {
		this.feedbackDescrizione = feedbackDescrizione;
	}
	public Long getFeedbackIdOpera()  {
		return this.feedbackIdOpera;
	}
	public void setFeedbackIdOpera(Long feedbackIdOpera) {
		this.feedbackIdOpera = feedbackIdOpera;
	}
	public Long getFeedbackIdUser()  {
		return this.feedbackIdUser;
	}
	public void setFeedbackIdUser(Long feedbackIdUser) {
		this.feedbackIdUser = feedbackIdUser;
	}
	public Integer getFeedbackTipo()  {
		return this.feedbackTipo;
	}
	public void setFeedbackTipo(Integer feedbackTipo) {
		this.feedbackTipo = feedbackTipo;
	}

	@Override
	public AutomationBean getNewInstance() {
		return new FeedbackBean();
	}
	
	
	

}