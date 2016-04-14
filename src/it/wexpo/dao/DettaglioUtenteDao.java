package it.wexpo.dao;

import it.wexpo.beanparsers.FeedbackOperaViewParser;
import it.wexpo.beans.FeedbackOperaViewBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;






import automation.parser.BeanParser;



public class DettaglioUtenteDao {

	
	
public static ArrayList<FeedbackOperaViewBean>  executeQweryMany(String sql, Connection conn, UsersBean user) throws SQLException{
		
		ArrayList<FeedbackOperaViewBean> list = new ArrayList<FeedbackOperaViewBean>();
		FeedbackOperaViewParser parser = new FeedbackOperaViewParser();
		try{
			String sqlParsed = sql.replaceAll("\\?", user.getUserId().toString());
			System.out.println(sqlParsed);
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sqlParsed);
			
			
			while (resultSet.next()){
				FeedbackOperaViewBean bean = parser.parseBean(resultSet);
				list.add(bean);
		    }
			
			return list;
			
		}finally{
			conn.close();
		}
	
}
	
}
