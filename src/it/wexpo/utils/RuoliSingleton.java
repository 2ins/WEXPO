package it.wexpo.utils;

import it.wexpo.autodao.RuoliAutoDao;
import it.wexpo.beanparsers.RuoliParser;
import it.wexpo.beans.ActiveBean;
import it.wexpo.beans.RuoliBean;
import it.wexpo.business.Business;

import java.sql.Connection;
import java.util.ArrayList;

public class RuoliSingleton {
	
	private static RuoliSingleton istanza;
	
	private ArrayList<RuoliBean> ruoli;
	private ArrayList<ActiveBean> stati;
	
	private RuoliSingleton() throws Exception{
		ruoli = Business.getRuoli();
		stati = getStatiDomain();
		
		
	}

	private ArrayList<ActiveBean> getStatiDomain() {
		stati = new ArrayList<ActiveBean>();
		ActiveBean a1 = new ActiveBean();
		a1.setId(0);
		a1.setDesc("Disattivato");
		
		ActiveBean a2 = new ActiveBean();
		a2.setId(1);
		a2.setDesc("Attivato");
		
		stati.add(a1);
		stati.add(a2);
		
		return stati;
	}
	
	public static ArrayList<ActiveBean> getStatiDomainAdminUsers() {
		ArrayList statiAdmin = new ArrayList<ActiveBean>();
		ActiveBean a1 = new ActiveBean();
		a1.setId(0);
		a1.setDesc("Disattivato");
		
		ActiveBean a2 = new ActiveBean();
		a2.setId(1);
		a2.setDesc("Attivato");
		
		ActiveBean a0 = new ActiveBean();
		a0.setId(-1);
		a0.setDesc("Non Confermato Mail");
		
		statiAdmin.add(a0);
		statiAdmin.add(a1);
		statiAdmin.add(a2);
		
		return statiAdmin;
	}
	
	public static RuoliSingleton getInstance() throws Exception{
		if (istanza == null) {
			istanza = new RuoliSingleton();
		}
		return istanza;
	}

	public ArrayList<RuoliBean> getRuoli() {
		return ruoli;
	}

	public void setRuoli(ArrayList<RuoliBean> ruoli) {
		this.ruoli = ruoli;
	}

	public ArrayList<ActiveBean> getStati() {
		return stati;
	}

	public void setStati(ArrayList<ActiveBean> stati) {
		this.stati = stati;
	}
	
	
	
}
