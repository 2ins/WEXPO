package it.wexpo.beans;

import java.lang.Long;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import automation.bean.AutomationBean;

public class FeedbackBigBean extends AutomationBean{
	private Long feedbackId;
	private Integer feedbackVoto;
	private String feedbackDescrizione;
	private Long feedbackIdOpera;
	private Date feedbackDate;
	
	private Long operaId;
	private Integer operaActive;
	private String operaDescrizione;
	private Long operaIdImmagine;
	private String operaImmagineHash;
	
	
	private Long userFeedbackId;
	private String userFeedbackNome;
	private String userFeedbackCognome;
	private Long userFeedbackFoto;
	private Long userFeedbackIdRuolo;
	private String userFeedbackImmagineHash;
	
	private Long userOperaId;
	private String userOperaNome;
	private String userOperaCognome;
	private Long userOperaFoto;
	private Long userOperaIdRuolo;
	private String userOperaImmagineHash;
	
	
	
	

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
	public Date getFeedbackDate()  {
		return this.feedbackDate;
	}
	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	public Long getOperaId()  {
		return this.operaId;
	}
	public void setOperaId(Long operaId) {
		this.operaId = operaId;
	}
	public Integer getOperaActive()  {
		return this.operaActive;
	}
	public void setOperaActive(Integer operaActive) {
		this.operaActive = operaActive;
	}
	public String getOperaDescrizione()  {
		return this.operaDescrizione;
	}
	public void setOperaDescrizione(String operaDescrizione) {
		this.operaDescrizione = operaDescrizione;
	}
	public Long getOperaIdImmagine()  {
		return this.operaIdImmagine;
	}
	public void setOperaIdImmagine(Long operaIdImmagine) {
		this.operaIdImmagine = operaIdImmagine;
	}
	public Long getUserFeedbackId()  {
		return this.userFeedbackId;
	}
	public void setUserFeedbackId(Long userFeedbackId) {
		this.userFeedbackId = userFeedbackId;
	}
	public String getUserFeedbackNome()  {
		return this.userFeedbackNome;
	}
	public void setUserFeedbackNome(String userFeedbackNome) {
		this.userFeedbackNome = userFeedbackNome;
	}
	public String getUserFeedbackCognome()  {
		return this.userFeedbackCognome;
	}
	public void setUserFeedbackCognome(String userFeedbackCognome) {
		this.userFeedbackCognome = userFeedbackCognome;
	}
	public Long getUserFeedbackFoto()  {
		return this.userFeedbackFoto;
	}
	public void setUserFeedbackFoto(Long userFeedbackFoto) {
		this.userFeedbackFoto = userFeedbackFoto;
	}
	public Long getUserFeedbackIdRuolo()  {
		return this.userFeedbackIdRuolo;
	}
	public void setUserFeedbackIdRuolo(Long userFeedbackIdRuolo) {
		this.userFeedbackIdRuolo = userFeedbackIdRuolo;
	}
	public Long getUserOperaId()  {
		return this.userOperaId;
	}
	public void setUserOperaId(Long userOperaId) {
		this.userOperaId = userOperaId;
	}
	public String getUserOperaNome()  {
		return this.userOperaNome;
	}
	public void setUserOperaNome(String userOperaNome) {
		this.userOperaNome = userOperaNome;
	}
	public String getUserOperaCognome()  {
		return this.userOperaCognome;
	}
	public void setUserOperaCognome(String userOperaCognome) {
		this.userOperaCognome = userOperaCognome;
	}
	public Long getUserOperaFoto()  {
		return this.userOperaFoto;
	}
	public void setUserOperaFoto(Long userOperaFoto) {
		this.userOperaFoto = userOperaFoto;
	}
	public Long getUserOperaIdRuolo()  {
		return this.userOperaIdRuolo;
	}
	public void setUserOperaIdRuolo(Long userOperaIdRuolo) {
		this.userOperaIdRuolo = userOperaIdRuolo;
	}
	

	public String getUserFeedbackImmagineHash() {
		return userFeedbackImmagineHash;
	}
	public void setUserFeedbackImmagineHash(String userFeedbackImmagineHash) {
		this.userFeedbackImmagineHash = userFeedbackImmagineHash;
	}
	public String getUserOperaImmagineHash() {
		return userOperaImmagineHash;
	}
	public void setUserOperaImmagineHash(String userOperaImmagineHash) {
		this.userOperaImmagineHash = userOperaImmagineHash;
	}
	public String getOperaImmagineHash() {
		return operaImmagineHash;
	}
	public void setOperaImmagineHash(String operaImmagineHash) {
		this.operaImmagineHash = operaImmagineHash;
	}
	@Override
	public AutomationBean getNewInstance() {
		return new FeedbackBigBean();
	}

}