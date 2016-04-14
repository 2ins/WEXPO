package it.wexpo.dao.compo;

import it.wexpo.autodao.OpereAutoDao;
import it.wexpo.autodao.UsersAutoDao;
import it.wexpo.bean.compo.OperaImmagineBean;
import it.wexpo.bean.compo.UserImmagineBean;
import it.wexpo.beanparsers.ImmaginiParser;
import it.wexpo.beanparsers.OpereParser;
import it.wexpo.beanparsers.UsersParser;
import it.wexpo.beans.ImmaginiBean;
import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.OpereBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.utils.WexpoMediaUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OpereImmagineDao {
	
	public ArrayList<OperaImmagineBean> select(OperaImmagineBean cerca, Connection conn){
		
		
		String select = "select * from opere o, immagini i, users u where o.opera_id_immagine=i.immagine_id and o.opera_id_user = u.user_id ";
		
		
		ArrayList<OperaImmagineBean> list = new ArrayList<OperaImmagineBean>();
		OpereAutoDao dao = new OpereAutoDao();
		
		Statement stmt;
		try {
			
			stmt = conn.createStatement();
			
			String cond = dao.getQueryConditionsAddendum(cerca.getOpera());
			if (!cond.equalsIgnoreCase("")){
				select = select + " and "+cond;
			}
			
			ResultSet resultSet = stmt.executeQuery(select);
			
			OpereParser parser = new OpereParser();
			ImmaginiParser parserImg = new ImmaginiParser();
			UsersParser parserUsr = new UsersParser()
			;
			while (resultSet.next()){
				
				OperaImmagineBean compo = new OperaImmagineBean();
				
				OpereBean opera = parser.parseBean(resultSet);
				ImmaginiBean img = parserImg.parseBean(resultSet);
				UsersBean usr = parserUsr.parseBean(resultSet);
				
				compo.setOpera(opera);
				compo.setImg(img);
				compo.setUser(usr);
				
				list.add(compo);
				
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(list.size());
		
		return list;
		
	
		
		
		
	} 
	
	

}
