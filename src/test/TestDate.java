package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
public static void main(String[] args){
	
	Date f = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String s = formatter.format(f);
	System.out.println(s);
	Calendar cal = Calendar.getInstance();
	cal.setTime(f);
	int mese  = formatter.getCalendar().get(Calendar.MONTH);
	mese++;
	int anno  = formatter.getCalendar().get(Calendar.YEAR);
	int giorno = formatter.getCalendar().get(Calendar.DAY_OF_MONTH);
	
	int ora = formatter.getCalendar().get(Calendar.HOUR);
	int min = formatter.getCalendar().get(Calendar.MINUTE);
	int sec = formatter.getCalendar().get(Calendar.SECOND);
	
	String date = "'"+anno+"-"+mese+"-"+giorno+" "+ora+":"+min+":"+sec+"'";
	System.out.println(date);
}
}
