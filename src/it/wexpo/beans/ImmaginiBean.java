package it.wexpo.beans;

import java.lang.Long;
import java.lang.String;
import automation.bean.AutomationBean;

public class ImmaginiBean extends AutomationBean{
	private Long immagineId;
	private String immagineNome;
	private String immagineHash;
	private String format;

	public Long getImmagineId()  {
		return this.immagineId;
	}
	public void setImmagineId(Long immagineId) {
		this.immagineId = immagineId;
	}
	public String getImmagineNome()  {
		return this.immagineNome;
	}
	public void setImmagineNome(String immagineNome) {
		this.immagineNome = immagineNome;
	}
	public String getImmagineHash()  {
		return this.immagineHash;
	}
	public void setImmagineHash(String immagineHash) {
		this.immagineHash = immagineHash;
	}

	@Override
	public AutomationBean getNewInstance() {
		return new ImmaginiBean();
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	
	
	

}