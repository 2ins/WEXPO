package it.wexpo.dao;


import it.wexpo.beanparsers.OperaViewParser;
import it.wexpo.beans.OperaViewBean;
import it.wexpo.utils.WexpoMediaUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import automation.parser.BeanParser;

public class OpereDao {
	
	
	public static ArrayList<OperaViewBean> executeQweryMany(String sql, Connection conn) throws SQLException{
		
		ArrayList<OperaViewBean> list = new ArrayList<OperaViewBean>();
		OperaViewParser parser = new OperaViewParser();
		try{
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			
			while (resultSet.next()){
				OperaViewBean bean = parser.parseBean(resultSet);
				String t = WexpoMediaUtils.getTimeUpdate(bean.getOperaDateInsert());
				bean.setTimeUpdate(t);
				list.add(bean);
		    }
			
			return list;
			
		}finally{
			conn.close();
		}
	
}
}
