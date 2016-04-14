package it.wexpo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
	public static Connection getMySqlConn() throws SQLException{
		DriverManager.registerDriver (new com.mysql.jdbc.Driver());
		//String jdbcConnectionUrl = "jdbc:mysql://wexpo.cqstzhwuyh3k.us-west-2.rds.amazonaws.com:3306/DIO";
		String jdbcConnectionUrl = "jdbc:mysql://130.211.93.124:3306/DIO";
		String user="root";
		String password = "M2A7AiE2";
		Connection conn = DriverManager.getConnection (jdbcConnectionUrl,user,password);  
		conn.setAutoCommit(false);
		return conn;
	}
}
