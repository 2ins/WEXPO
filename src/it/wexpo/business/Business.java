package it.wexpo.business;

import java.sql.Connection;
import java.util.ArrayList;

import it.wexpo.autodao.RuoliAutoDao;
import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.RuoliBean;
import it.wexpo.utils.DbUtils;
import it.wexpo.utils.RuoliSingleton;

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
	public static ArrayList<RuoliBean> popolaRuoli() throws Exception {
		ArrayList<RuoliBean> ruoli = RuoliSingleton.getInstance().getRuoli();
	
		return ruoli;
	}

}
