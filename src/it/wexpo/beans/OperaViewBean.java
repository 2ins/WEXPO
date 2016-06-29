package it.wexpo.beans;

import it.wexpo.utils.WexpoMediaUtils;

import java.lang.String;
import java.lang.Long;
import java.lang.Integer;
import java.util.ArrayList;
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
	
	private String website;
	
	private String facebookLink;
	private String youtubeLink;
	private String googleLink;
	private String twitterLink;

	private ArrayList<String> tags;
	
	
	private String operaTitoloEng;
	private String operaDescrizioneEng;
	

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
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getFacebookLink() {
		return facebookLink;
	}
	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}
	public String getYoutubeLink() {
		return youtubeLink;
	}
	public void setYoutubeLink(String youtubeLink) {
		this.youtubeLink = youtubeLink;
	}
	public String getGoogleLink() {
		return googleLink;
	}
	public void setGoogleLink(String googleLink) {
		this.googleLink = googleLink;
	}
	public String getTwitterLink() {
		return twitterLink;
	}
	public void setTwitterLink(String twitterLink) {
		this.twitterLink = twitterLink;
	}
	public ArrayList<String> getTags() {
		return tags;
	}
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	public String getOperaTitoloEng() {
		return operaTitoloEng;
	}
	public void setOperaTitoloEng(String operaTitoloEng) {
		this.operaTitoloEng = operaTitoloEng;
	}
	public String getOperaDescrizioneEng() {
		return operaDescrizioneEng;
	}
	public void setOperaDescrizioneEng(String operaDescrizioneEng) {
		this.operaDescrizioneEng = operaDescrizioneEng;
	}
	
	

}