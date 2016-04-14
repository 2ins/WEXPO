package it.wexpo.dao.compo;

import it.wexpo.autodao.UsersAutoDao;
import it.wexpo.bean.compo.UserImmagineBean;
import it.wexpo.beanparsers.ImmaginiParser;
import it.wexpo.beanparsers.UsersParser;
import it.wexpo.beans.ImmaginiBean;
import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.utils.WexpoMediaUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserImmagineDao {
	
	public ArrayList<UserImmagineBean> select(UserImmagineBean cerca, Connection conn){
		
		
		String select = "select * from users u left join immagini i on u.user_foto=i.immagine_id ";
		
		
		ArrayList<UserImmagineBean> list = new ArrayList<UserImmagineBean>();
		UsersAutoDao dao = new UsersAutoDao();
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			
			
			String cond = dao.getQueryConditionsAddendum(cerca.getUser());
			if (!cond.equalsIgnoreCase("")){
				select = select + " where "+cond;
			}
			System.out.println(select);
			ResultSet resultSet = stmt.executeQuery(select);
			
			UsersParser parser = new UsersParser();
			ImmaginiParser parserImg = new ImmaginiParser();
			
			while (resultSet.next()){
				
				UserImmagineBean compo = new UserImmagineBean();
				
				UsersBean user = parser.parseBean(resultSet);
				
				ImmaginiBean img = parserImg.parseBean(resultSet);
				
				compo.setUser(user);
				compo.setImg(img);
				
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
