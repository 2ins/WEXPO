package test;

import it.wexpo.beanparsers.OperaViewParser;
import it.wexpo.beans.OperaViewBean;
import it.wexpo.dao.SqlQuery;
import it.wexpo.utils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class TestMySql {
public static ArrayList<TestBean>  executeQweryMany(String sql, Connection conn) throws SQLException{
		
		ArrayList<TestBean> list = new ArrayList<TestBean>();
		TestParser parser = new TestParser();
		try{
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			
			while (resultSet.next()){
				TestBean bean = parser.parseBean(resultSet);
				list.add(bean);
		    }
			
			return list;
			
		}finally{
			conn.close();
		}
	
}

public static void main(String[] args) throws SQLException{
	Date t1 = new Date();
	Connection conn = DbUtils.getMySqlConn();
	Date t2 = new Date();
	ArrayList<TestBean> list = executeQweryMany(SqlQuery.FEED_OPERA_OPERAUSER_BY_USER, conn);
	Date t3 = new Date();
	System.out.println(list.get(0).getX1());
	System.out.println(t2.getTime()-t1.getTime());
	System.out.println(t3.getTime()-t2.getTime());
}



}
