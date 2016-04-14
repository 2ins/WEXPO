package it.wexpo.beans;

import java.lang.Long;
import java.lang.String;
import automation.bean.AutomationBean;

public class VenditeBean extends AutomationBean{
	private Long venditaId;
	private String venditaStato;
	private String venditaNote;
	private Long venditaIdOpera;

	public Long getVenditaId()  {
		return this.venditaId;
	}
	public void setVenditaId(Long venditaId) {
		this.venditaId = venditaId;
	}
	public String getVenditaStato()  {
		return this.venditaStato;
	}
	public void setVenditaStato(String venditaStato) {
		this.venditaStato = venditaStato;
	}
	public String getVenditaNote()  {
		return this.venditaNote;
	}
	public void setVenditaNote(String venditaNote) {
		this.venditaNote = venditaNote;
	}
	public Long getVenditaIdOpera()  {
		return this.venditaIdOpera;
	}
	public void setVenditaIdOpera(Long venditaIdOpera) {
		this.venditaIdOpera = venditaIdOpera;
	}

	@Override
	public AutomationBean getNewInstance() {
		return new VenditeBean();
	}

}