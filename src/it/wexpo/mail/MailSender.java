package it.wexpo.mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

	public static void main(String[] args) {
		//extraSend();
		//tlsSend();
		sslSend("ciao", "federico.frascarelli@gmail.com", "benvegnu");
	}
	
	
	public static void extraSend() {
		 Properties props = new Properties();
		    Session session = Session.getDefaultInstance(props, null);

		    String msgBody = "...kjasdkasdkbakjbdkajbdkjabsd";

		    try {
		        Message msg = new MimeMessage(session);
		        msg.setFrom(new InternetAddress("federico.frascarelli@libero.it", "Example.com Admin"));
		        msg.addRecipient(Message.RecipientType.TO, new InternetAddress("federico.frascarelli@gmail.com", "Mr. User"));
		        msg.setSubject("Your Example.com account has been activated");
		        msg.setText(msgBody);
		        Transport.send(msg);

		    } catch (AddressException e) {
		        e.printStackTrace();
		    } catch (MessagingException e) {
		    	e.printStackTrace();
		    } catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
	}
	
	public static void sslSend(String bodyMessage, String emailTo, String title) {
		Properties props = new Properties();
		
		props.put("mail.smtp.host", "authsmtp.federicofrascarelli.it");
		props.put("mail.smtp.socketFactory.port", "49153");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "49153");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("smtp@federicofrascarelli.it","Federico1981@");
				}
			});

		try {

			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("no-replay@wexpo.it"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
			message.setSubject(title);

			
			message.setText(bodyMessage);

			Transport.send(message);
			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	private static void tlsSend() {
		final String username = "federico.frascarelli";
		final String password = "drStrangeLove";

		Properties props = new Properties();
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("federico.frascarelli@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("federico.frascarelli@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}