package it.wexpo.beans;

import java.lang.Long;
import java.lang.String;
import java.util.Date;
import automation.bean.AutomationBean;

public class ConcorsiBean extends AutomationBean{
	private Long concorsoId;
	private String concorsoTitolo;
	private String concorsoDescrizione;
	private Long concorsoIdImg1;
	private Long concorsoIdImg2;
	private Long concorsoIdImg3;
	private Date concorsoDataIn;
	private Date concorsoDataOut;

	public Long getConcorsoId()  {
		return this.concorsoId;
	}
	public void setConcorsoId(Long concorsoId) {
		this.concorsoId = concorsoId;
	}
	public String getConcorsoTitolo()  {
		return this.concorsoTitolo;
	}
	public void setConcorsoTitolo(String concorsoTitolo) {
		this.concorsoTitolo = concorsoTitolo;
	}
	public String getConcorsoDescrizione()  {
		return this.concorsoDescrizione;
	}
	public void setConcorsoDescrizione(String concorsoDescrizione) {
		this.concorsoDescrizione = concorsoDescrizione;
	}
	public Long getConcorsoIdImg1()  {
		return this.concorsoIdImg1;
	}
	public void setConcorsoIdImg1(Long concorsoIdImg1) {
		this.concorsoIdImg1 = concorsoIdImg1;
	}
	public Long getConcorsoIdImg2()  {
		return this.concorsoIdImg2;
	}
	public void setConcorsoIdImg2(Long concorsoIdImg2) {
		this.concorsoIdImg2 = concorsoIdImg2;
	}
	public Long getConcorsoIdImg3()  {
		return this.concorsoIdImg3;
	}
	public void setConcorsoIdImg3(Long concorsoIdImg3) {
		this.concorsoIdImg3 = concorsoIdImg3;
	}
	public Date getConcorsoDataIn()  {
		return this.concorsoDataIn;
	}
	public void setConcorsoDataIn(Date concorsoDataIn) {
		this.concorsoDataIn = concorsoDataIn;
	}
	public Date getConcorsoDataOut()  {
		return this.concorsoDataOut;
	}
	public void setConcorsoDataOut(Date concorsoDataOut) {
		this.concorsoDataOut = concorsoDataOut;
	}

	@Override
	public AutomationBean getNewInstance() {
		return new ConcorsiBean();
	}

}