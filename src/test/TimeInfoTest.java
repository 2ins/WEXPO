package test;

import it.wexpo.utils.WexpoMediaUtils;

import java.util.Date;

public class TimeInfoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d1 = new Date();
		d1.setSeconds(15);
		Date d2 = new Date();
		d2.setDate(6);
		
		Date d3 = new Date();
		d3.setMinutes(43);
		
		Date d4 = new Date();
		d4.setHours(13);
		
		String x1 = WexpoMediaUtils.getTimeUpdate(d1);
		String x2 = WexpoMediaUtils.getTimeUpdate(d2);
		String x3 = WexpoMediaUtils.getTimeUpdate(d3);
		String x4 = WexpoMediaUtils.getTimeUpdate(d4);
		
		System.out.println(x1);
		System.out.println(x2);
		System.out.println(x3);
		System.out.println(x4);
		
	}

}
