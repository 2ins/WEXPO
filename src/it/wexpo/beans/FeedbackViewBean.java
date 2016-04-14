package it.wexpo.beans;

import it.wexpo.utils.WexpoMediaUtils;

import java.lang.Long;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;

import automation.bean.AutomationBean;

public class FeedbackViewBean extends AutomationBean{
	private Long feedbackId;
	private Integer feedbackVoto;
	private String feedbackDescrizione;
	private Long feedbackIdOpera;
	private Long feedbackIdUser;
	private Integer feedbackTipo;
	
	
	
	private String userNome;
	private String userCognome;
	private Long userFoto;
	private String userHashFoto;
	private Long userId;
	
	

	
	public ArrayList<Integer> getStarsImg(){
		if (feedbackVoto==null)
			return null;
		Float x = (float)feedbackVoto/2;
		return WexpoMediaUtils.getRateAsIntegerArray(x);
	}
	
	
	
	

	
	
	
	
	
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
		return new FeedbackViewBean();
	}
	public String getUserNome() {
		return userNome;
	}
	public void setUserNome(String userNome) {
		this.userNome = userNome;
	}
	public String getUserCognome() {
		return userCognome;
	}
	public void setUserCognome(String userCognome) {
		this.userCognome = userCognome;
	}
	public Long getUserFoto() {
		return userFoto;
	}
	public void setUserFoto(Long userFoto) {
		this.userFoto = userFoto;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserHashFoto() {
		return userHashFoto;
	}
	public void setUserHashFoto(String userHashFoto) {
		this.userHashFoto = userHashFoto;
	}
	

}