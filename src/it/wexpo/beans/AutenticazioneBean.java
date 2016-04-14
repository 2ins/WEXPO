package it.wexpo.beans;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import automation.bean.AutomationBean;

public class AutenticazioneBean extends AutomationBean{
	private Long iduser;
	private String emailuser;
	private String token;
	private Date date;
	private Date expire;
	private String tipo;

	public Long getIduser()  {
		return this.iduser;
	}
	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}
	public String getEmailuser()  {
		return this.emailuser;
	}
	public void setEmailuser(String emailuser) {
		this.emailuser = emailuser;
	}
	public String getToken()  {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getDate()  {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getExpire()  {
		return this.expire;
	}
	public void setExpire(Date expire) {
		this.expire = expire;
	}
	public String getTipo()  {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public AutomationBean getNewInstance() {
		return new AutenticazioneBean();
	}

}