package it.wexpo.mail;

import it.wexpo.beans.UsersBean;

public class MailProcessor {

		private static final String EMAIL_FROM = "no-replay@wexpo.it";
	
		public static void eseguiBenvenuto(UsersBean user, String token){
			String bodyMessage = MailGenerator.getInstance().getBenvenuto(user,token);
			String title="Benvenuto su Wexpo";
			String emailTo = user.getUserEmail();
			//MailSender.sslSend(bodyMessage, emailTo, title);
			SendGridMailer.sendMail(EMAIL_FROM, emailTo, title, bodyMessage);
		}

		public static void eseguiPasswordDimenticata(UsersBean user,
				String token) {
			String bodyMessage = MailGenerator.getInstance().getPasswDimenticata(user,token);
			String title="Reset Password su Wexpo";
			String emailTo = user.getUserEmail();
			//MailSender.sslSend(bodyMessage, emailTo, title);
			SendGridMailer.sendMail(EMAIL_FROM, emailTo, title, bodyMessage);
			
		}
}
