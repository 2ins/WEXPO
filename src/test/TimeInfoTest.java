package test;

import it.wexpo.utils.WexpoMediaUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeInfoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d1 = new Date();
		
		
		
		String s = "2016-06-25 16:56:26";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try
        {
            Date date = simpleDateFormat.parse(s);

            System.out.println("date : "+simpleDateFormat.format(date));
            
            String x1 = WexpoMediaUtils.getTimeUpdate(date);
    		
    		System.out.println(x1);
        }
        catch (ParseException ex)
        {
            System.out.println("Exception "+ex);
        }
        
       
		 
		
	}
	
	


}
