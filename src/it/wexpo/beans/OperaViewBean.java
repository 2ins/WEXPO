package it.wexpo.beans;

import it.wexpo.utils.WexpoMediaUtils;

import java.lang.String;
import java.lang.Long;
import java.lang.Integer;
import java.util.Date;

import automation.bean.AutomationBean;

public class OperaViewBean extends ViewBean{
	private String operaTitolo;
	private String operaDescrizione;
	private Long operaId;
	private Date operaDateInsert;
	private String timeUpdate;
	
	private Integer operaActive;

	private Long userId;
	private String userNome;
	private String userCognome;
	private String userLink;
	private Long userFoto;
	private String userImmagineHash;
	private Long immagineId;
	private String immagineHash;
	private Integer feedbackVoto;

	
	
	

	public String getTimeUpdate() {
		return timeUpdate;
	}
	public void setTimeUpdate(String timeUpdate) {
		this.timeUpdate = timeUpdate;
	}
	public String getOperaTitolo()  {
		return this.operaTitolo;
	}
	public void setOperaTitolo(String operaTitolo) {
		this.operaTitolo = operaTitolo;
	}
	public String getOperaDescrizione()  {
		return this.operaDescrizione;
	}
	public void setOperaDescrizione(String operaDescrizione) {
		this.operaDescrizione = operaDescrizione;
	}
	public Long getOperaId()  {
		return this.operaId;
	}
	public void setOperaId(Long operaId) {
		this.operaId = operaId;
	}

	public Long getUserId()  {
		return this.userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserNome()  {
		return this.userNome;
	}
	public void setUserNome(String userNome) {
		this.userNome = userNome;
	}
	public String getUserCognome()  {
		return this.userCognome;
	}
	public void setUserCognome(String userCognome) {
		this.userCognome = userCognome;
	}
	public String getUserLink()  {
		return this.userLink;
	}
	public void setUserLink(String userLink) {
		this.userLink = userLink;
	}
	public Long getImmagineId()  {
		return this.immagineId;
	}
	public void setImmagineId(Long immagineId) {
		this.immagineId = immagineId;
	}
	public String getImmagineHash()  {
		return this.immagineHash;
	}
	public void setImmagineHash(String immagineHash) {
		this.immagineHash = immagineHash;
	}
	

	public Integer getFeedbackVoto() {
		return feedbackVoto;
	}
	public void setFeedbackVoto(Integer feedbackVoto) {
		this.feedbackVoto = feedbackVoto;
	}
	@Override
	public AutomationBean getNewInstance() {
		return new OperaViewBean();
	}

	

	
	

	public Long getUserFoto() {
		return userFoto;
	}
	public void setUserFoto(Long userFoto) {
		this.userFoto = userFoto;
	}
	public String getUserImmagineHash() {
		return userImmagineHash;
	}
	public void setUserImmagineHash(String userImmagineHash) {
		this.userImmagineHash = userImmagineHash;
	}
	public Date getOperaDateInsert() {
		return operaDateInsert;
	}
	public void setOperaDateInsert(Date operaDateInsert) {
		this.operaDateInsert = operaDateInsert;
	}
	public Integer getOperaActive() {
		return operaActive;
	}
	public void setOperaActive(Integer operaActive) {
		this.operaActive = operaActive;
	}
	
	

}