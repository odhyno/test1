package logic.utility;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class MailSender {
	
	static final String HOST = "smtp.gmail.com";
	static final String EMAILSERVERPORT = "465";

	public void sendMail(String email, String username, String password) {
		
		String to = email;
		String from = "socialmusicproj@gmail.com";
	
		Properties props = System.getProperties(); 
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.host", HOST);
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", EMAILSERVERPORT);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		
		Authenticator auth = new SMTPAuthenticator();

		// Construct the message		
		
		try {
			Session session = Session.getInstance(props, auth);
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setText("As your request, these are your data:\n\nUsername: " + username + "\nPassword: " + password
					+ "\n\nMany Greetings from SocialMusic!!!");

			msg.setSubject("SocialMusic Data Request:");

			// Send the message.
			Transport.send(msg);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("socialmusicproj@gmail.com", "SocialMusic");
		}
	}
}
