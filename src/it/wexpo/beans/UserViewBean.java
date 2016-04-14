package it.wexpo.beans;

import java.lang.Long;
import java.lang.String;
import java.util.Date;

import automation.bean.AutomationBean;

public class UserViewBean extends ViewBean{
	private Long userId;
	private String userNome;
	private String userCognome;
	private Date userDataNascita;
	private String userLuogoResidenza;
	private String userCitta;
	private String userNazione;
	private Long userFoto;
	private Long userCv;
	private String userEmail;
	private String userLink;

	private Long userIdRuolo;
	private Integer userActive;
	
	
	private String userImmagine;
	
	//solo per ricerca utenti -> 
	private Integer numeroOpere;

	
	

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
	public Date getUserDataNascita()  {
		return this.userDataNascita;
	}
	public void setUserDataNascita(Date userDataNascita) {
		this.userDataNascita = userDataNascita;
	}
	public String getUserLuogoResidenza()  {
		return this.userLuogoResidenza;
	}
	public void setUserLuogoResidenza(String userLuogoResidenza) {
		this.userLuogoResidenza = userLuogoResidenza;
	}
	public String getUserCitta()  {
		return this.userCitta;
	}
	public void setUserCitta(String userCitta) {
		this.userCitta = userCitta;
	}
	public String getUserNazione()  {
		return this.userNazione;
	}
	public void setUserNazione(String userNazione) {
		this.userNazione = userNazione;
	}
	public Long getUserFoto()  {
		return this.userFoto;
	}
	public void setUserFoto(Long userFoto) {
		this.userFoto = userFoto;
	}
	public Long getUserCv()  {
		return this.userCv;
	}
	public void setUserCv(Long userCv) {
		this.userCv = userCv;
	}
	public String getUserEmail()  {
		return this.userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserLink()  {
		return this.userLink;
	}
	public void setUserLink(String userLink) {
		this.userLink = userLink;
	}
	public Long getUserIdRuolo()  {
		return this.userIdRuolo;
	}
	public void setUserIdRuolo(Long userIdRuolo) {
		this.userIdRuolo = userIdRuolo;
	}

	@Override
	public AutomationBean getNewInstance() {
		return new UserViewBean();
	}
	public Integer getNumeroOpere() {
		return numeroOpere;
	}
	public void setNumeroOpere(Integer numeroOpere) {
		this.numeroOpere = numeroOpere;
	}
	public String getUserImmagine() {
		return userImmagine;
	}
	public void setUserImmagine(String userImmagine) {
		this.userImmagine = userImmagine;
	}
	public Integer getUserActive() {
		return userActive;
	}
	public void setUserActive(Integer userActive) {
		this.userActive = userActive;
	}


	
	

}