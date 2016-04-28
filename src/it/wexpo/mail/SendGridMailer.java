package it.wexpo.mail;

import javax.naming.NamingException;

import it.wexpo.utils.EnvironmentUtils;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

public class SendGridMailer {
	public static void sendMail(String emailFrom, String emailto, String emailSubject, String htmlBody) throws NamingException {
		  
		String sendKey = EnvironmentUtils.getSendGridKey();
	    SendGrid sendgrid = new SendGrid("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");

	    SendGrid.Email email = new SendGrid.Email();

	    email.addTo(emailto);
	    email.setFrom(emailFrom);
	    email.setSubject(emailSubject);
	    email.setHtml(htmlBody);

	    try {
			SendGrid.Response response = sendgrid.send(email);
			System.out.println(response.getMessage());
		} catch (SendGridException e) {
			System.out.println("errori");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
}
