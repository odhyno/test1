package logic.utils;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class MailSender {

	final String emailSMTPserver = "smtp.gmail.com";
	final String emailServerPort = "465";
	String receiverEmailID = null;

	public void sendMail(String receiverEmailID, String username, String password) {

		this.receiverEmailID = receiverEmailID;

		Properties props = new Properties();
		props.put("mail.smtp.user", "socialmusicproj@gmail.com");
		props.put("mail.smtp.host", emailSMTPserver);
		props.put("mail.smtp.port", emailServerPort);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", emailServerPort);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			MimeMessage msg = new MimeMessage(session);
			msg.setText("As your request, these are your data:\n\nUsername: " + username + "\nPassword: " + password
					+ "\n\nMany Greetings from SocialMusic!!!");

			msg.setSubject("SocialMusic Data Request:");
			msg.setFrom(new InternetAddress("socialmusicproj@gmail.com"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmailID));
			Transport.send(msg);
		} catch (Exception mex) {
			mex.printStackTrace();
		}
	}

	public class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("socialmusicproj@gmail.com", "SocialMusic");
		}
	}
}
