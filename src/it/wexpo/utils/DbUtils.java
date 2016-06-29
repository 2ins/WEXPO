package it.wexpo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbUtils {
	public static Connection getMySqlConn() throws SQLException{
		
		return getConnFromJndi();
	}
	/*
	public static Connection getConn() throws SQLException{
		DriverManager.registerDriver (new com.mysql.jdbc.Driver());
		String jdbcConnectionUrl = "jdbc:mysql://127.0.0.1:3306/DIO";
		//String jdbcConnectionUrl = "jdbc:mysql://130.211.93.124:3306/DIO";
		String user="root";
		//String password = "M2A7AiE2";
		String password = "";
		Connection conn = DriverManager.getConnection (jdbcConnectionUrl,user,password);  
		conn.setAutoCommit(false);
		return conn;
	}
	*/
public static Connection getConnFromJndi() throws   SQLException{
		
		Context ctx;
		try {
			ctx = new InitialContext();
		
		DataSource ds = null;
		
		ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MYSQL");	
	 
		Connection conn = ds.getConnection();
		conn.setAutoCommit(false);
		return conn;
		
		} catch (NamingException e) {
			e.printStackTrace();
			throw new SQLException(e);
		}
	 
	
	}
}
