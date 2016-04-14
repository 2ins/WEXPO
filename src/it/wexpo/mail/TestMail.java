package it.wexpo.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TestMail {
	
	
	public static void main(String[] args) {
		try {
			sendMail("federico.frascarelli@gmail.com", "federico.frascarelli@libero.it", "wsfsdfsdf", "asodnaosdapsdnaosdn");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	 public static void sendMail (String dest, String mitt, String oggetto, String testoEmail)
		      throws MessagingException
		  {
		    // Creazione di una mail session
		    Properties props = new Properties();
		    props.put("mail.smtp.host", "smtp.libero.it");
		    Session session = Session.getDefaultInstance(props);

		    // Creazione del messaggio da inviare
		    MimeMessage message = new MimeMessage(session);
		    message.setSubject(oggetto);
		    message.setText(testoEmail);

		    // Aggiunta degli indirizzi del mittente e del destinatario
		    InternetAddress fromAddress = new InternetAddress(mitt);
		    InternetAddress toAddress = new InternetAddress(dest);
		    message.setFrom(fromAddress);
		    message.setRecipient(Message.RecipientType.TO, toAddress);

		    // Invio del messaggio
		    Transport.send(message);
		  }
}
