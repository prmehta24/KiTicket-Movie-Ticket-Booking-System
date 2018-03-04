/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor./*
 */

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
public class SendMailTLS {

	public static void main(String[] args) {

		final String username = "vectorparker0047@gmail.com"; // enter your mail id
		final String password = "iamvector0047";// enter ur password

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new Authenticator() {
                        @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("vectorparker0047@gmail.com")); // same email id
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("parthpanchaltemp@gmail.com"));// whome u have to send mails that person id
			message.setSubject("Test case1");
			message.setText("ashgfjh,"
				+ "\n\n asdf");

			Transport.send(message);

			System.out.println("Done");
                        JOptionPane.showMessageDialog(null,"Email sended!");

		} catch (MessagingException e) {
                    JOptionPane.showMessageDialog(null,"Something happened!");
			throw new RuntimeException(e);
		}
	}
}