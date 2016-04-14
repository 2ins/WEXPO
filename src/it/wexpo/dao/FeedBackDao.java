package it.wexpo.dao;

import it.wexpo.beanparsers.FeedbackViewParser;
import it.wexpo.beanparsers.OperaViewParser;
import it.wexpo.beans.FeedbackViewBean;
import it.wexpo.beans.OperaViewBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FeedBackDao {
	
public static ArrayList<FeedbackViewBean> executeQweryMany(String sql, Connection conn) throws SQLException{
		System.out.println(sql);
		ArrayList<FeedbackViewBean> list = new ArrayList<FeedbackViewBean>();
		FeedbackViewParser parser = new FeedbackViewParser();
		try{
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			
			while (resultSet.next()){
				FeedbackViewBean bean = parser.parseBean(resultSet);
				list.add(bean);
		    }
			
			return list;
			
		}finally{
			conn.close();
		}
	
}
}
