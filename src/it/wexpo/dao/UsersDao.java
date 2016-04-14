package it.wexpo.dao;

import it.wexpo.beanparsers.OperaViewParser;
import it.wexpo.beanparsers.UserViewParser;
import it.wexpo.beanparsers.UsersParser;
import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.UserViewBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.utils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsersDao {
public static ArrayList<UserViewBean> executeQweryMany(String sql, Connection conn) throws SQLException{
		System.out.println(sql);
		ArrayList<UserViewBean> list = new ArrayList<UserViewBean>();
		UserViewParser parser = new UserViewParser();
		try{
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			
			while (resultSet.next()){
				UserViewBean bean = parser.parseBean(resultSet);
				list.add(bean);
		    }
			
			return list;
			
		}finally{
			conn.close();
		}
	
}



}
