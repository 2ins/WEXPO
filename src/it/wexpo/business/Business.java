package it.wexpo.business;

import java.sql.Connection;
import java.util.ArrayList;

import it.wexpo.autodao.RuoliAutoDao;
import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.RuoliBean;
import it.wexpo.utils.DbUtils;

public class Business {
	
	public static ArrayList<RuoliBean> getRuoli() throws Exception{
		RuoliBean bean = new RuoliBean();
		RuoliAutoDao dao = new RuoliAutoDao();
		
		Connection conn = DbUtils.getMySqlConn();
		try{
			ArrayList<RuoliBean> ruoli = dao.select(bean, conn);
			return ruoli;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}
	public static ArrayList<RuoliBean> popolaRuoli() {
		ArrayList<RuoliBean> ruoli = new ArrayList<RuoliBean>();
		RuoliBean r1 = new RuoliBean();
		r1.setRuoloId(new Long(0));
		r1.setRuoloDescrizione("Espositore");
		RuoliBean r2 = new RuoliBean();
		r2.setRuoloId(new Long(1));
		r2.setRuoloDescrizione("Espositore/Giudice Popolare");
		RuoliBean r3 = new RuoliBean();
		r3.setRuoloId(new Long(2));
		r3.setRuoloDescrizione("Giudice Critico");
		
		
		//ruoli.add(r1);
		ruoli.add(r2);
		ruoli.add(r3);
		return ruoli;
	}

}
