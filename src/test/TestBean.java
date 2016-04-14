package test;

import java.lang.String;
import automation.bean.AutomationBean;

public class TestBean extends AutomationBean{
	
	private String x1;
	private String x2;
	

	
	public String getX1() {
		return x1;
	}



	public void setX1(String x1) {
		this.x1 = x1;
	}



	public String getX2() {
		return x2;
	}



	public void setX2(String x2) {
		this.x2 = x2;
	}



	@Override
	public AutomationBean getNewInstance() {
		return new TestBean();
	}

}