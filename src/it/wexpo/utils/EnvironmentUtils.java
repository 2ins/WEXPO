package it.wexpo.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EnvironmentUtils {
	
	
	private static String SENDGRID_KEY="sendGridKey";
	private static String SERVER_URL="serverUrl";
	
	public static String getServerUrl() throws NamingException{
		return getEnvContextVariabile(SERVER_URL);
	}
	
	
	public static String getSendGridKey() throws NamingException{
		return getEnvContextVariabile(SENDGRID_KEY);
	}

	private static String getEnvContextVariabile(String key) throws NamingException {
		InitialContext initialContext = new InitialContext();
		Context environmentContext = (Context) initialContext.lookup("java:/comp/env");
		String url = (String) environmentContext.lookup(key);
		return url;
	}
	
	
}
