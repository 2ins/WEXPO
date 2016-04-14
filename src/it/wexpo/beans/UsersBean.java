package it.wexpo.beans;

import java.lang.Long;
import java.lang.String;
import java.util.Date;
import automation.bean.AutomationBean;

public class UsersBean extends AutomationBean{
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
	private String userPassword;
	private Long userIdRuolo;
	private Integer userActive;
	
	private RuoliBean ruolo;
	private ActiveBean stato;
	

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
	public String getUserPassword()  {
		return this.userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Long getUserIdRuolo()  {
		return this.userIdRuolo;
	}
	public void setUserIdRuolo(Long userIdRuolo) {
		this.userIdRuolo = userIdRuolo;
	}
	public Integer getUserActive() {
		return userActive;
	}
	public void setUserActive(Integer userActive) {
		this.userActive = userActive;
	}
	@Override
	public AutomationBean getNewInstance() {
		return new UsersBean();
	}
	
	
	//ADDENDUM
	public boolean isActive() {
		if (userActive==1) return true;
		return false;
	}
	public RuoliBean getRuolo() {
		return ruolo;
	}
	public void setRuolo(RuoliBean ruolo) {
		this.ruolo = ruolo;
		if (ruolo!=null){
			this.userIdRuolo = ruolo.getRuoloId();
		}else{
			this.userIdRuolo = null;
		}
		
	}
	public ActiveBean getStato() {
		return stato;
	}
	public void setStato(ActiveBean stato) {
		this.stato = stato;
		if (stato!=null){
			this.userActive = stato.getId();
		}else{
			this.userActive = null;
		}
	}
	
	
	

}