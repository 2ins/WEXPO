package test;

import com.sendgrid.*;

public class SendGridExample {
  public static void main(String[] args) {
	  
    SendGrid sendgrid = new SendGrid("SENDGRID_APIKEY");

    SendGrid.Email email = new SendGrid.Email();

    email.addTo("federico.frascarelli@gmail.com");
    email.setFrom("federico.frascarelli@gmail.com");
    email.setSubject("Sending with SendGrid is Fun");
    email.setHtml("and easy to do anywhere, even with Java");

    try {
		SendGrid.Response response = sendgrid.send(email);
	} catch (SendGridException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}