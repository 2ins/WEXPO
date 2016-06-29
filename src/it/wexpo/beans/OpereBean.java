package it.wexpo.beans;

import java.lang.Long;
import java.lang.String;
import java.lang.Integer;
import java.util.Date;

import automation.bean.AutomationBean;

public class OpereBean extends AutomationBean{
	private Long operaId;
	private String operaTitolo;
	private String operaDescrizione;
	private Long operaIdUser;
	private Integer operaRatePop;
	private Integer operaRateCrit;
	private Long operaIdImmagine;
	private Integer operaRatePopFeeds;
	private Integer operaRateCritFeeds;
	private Date operaInsert;
	private Date operaUpdate;
	
	private Integer operaActive;
	private ActiveBean stato;
	
	
	private String operaTitoloEng;
	private String operaDescrizioneEng;
	

	public Long getOperaId()  {
		return this.operaId;
	}
	public void setOperaId(Long operaId) {
		this.operaId = operaId;
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
	public Long getOperaIdUser()  {
		return this.operaIdUser;
	}
	public void setOperaIdUser(Long operaIdUser) {
		this.operaIdUser = operaIdUser;
	}
	public Integer getOperaRatePop()  {
		return this.operaRatePop;
	}
	public void setOperaRatePop(Integer operaRatePop) {
		this.operaRatePop = operaRatePop;
	}
	public Integer getOperaRateCrit()  {
		return this.operaRateCrit;
	}
	public void setOperaRateCrit(Integer operaRateCrit) {
		this.operaRateCrit = operaRateCrit;
	}
	public Long getOperaIdImmagine()  {
		return this.operaIdImmagine;
	}
	public void setOperaIdImmagine(Long operaIdImmagine) {
		this.operaIdImmagine = operaIdImmagine;
	}

	@Override
	public AutomationBean getNewInstance() {
		return new OpereBean();
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
	public Date getOperaInsert() {
		return operaInsert;
	}
	public void setOperaInsert(Date operaInsert) {
		this.operaInsert = operaInsert;
	}
	public Date getOperaUpdate() {
		return operaUpdate;
	}
	public void setOperaUpdate(Date operaUpdate) {
		this.operaUpdate = operaUpdate;
	}
	public Integer getOperaActive() {
		return operaActive;
	}
	public void setOperaActive(Integer operaActive) {
		this.operaActive = operaActive;
	}
	
	//ADDENDUM
	public boolean isActive() {
		if (operaActive==1) return true;
		return false;
	}
	public ActiveBean getStato() {
		return stato;
	}
	public void setStato(ActiveBean stato) {
		this.stato = stato;
		if (stato!=null){
			this.operaActive = stato.getId();
		}else{
			this.operaActive = null;
		}
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