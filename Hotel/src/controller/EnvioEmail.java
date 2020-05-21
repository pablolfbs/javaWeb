package controller;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnvioEmail {

	public static void send(String destinatario, String corpoMensagem) {
		Properties props = new Properties();

		/** Configura��o para acesso smtp */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("", "");// Autentica��o
			}
		});

		/** Ativa Debug para sess�o */
		session.setDebug(true);

		try {

			// String corpoMensagem = "Mensagem de teste";

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(""));

//			Address[] toUser = InternetAddress.parse("lista de emails");// Array de Destinat�rios
			Address[] toUser = InternetAddress.parse(destinatario);// Array de Destinat�rios

			message.setRecipients(Message.RecipientType.TO, toUser);// Destinat�rios
			message.setSubject("Envio Email JavaMail");// Assunto
			message.setText(corpoMensagem);// Corpo do eamil
			Transport.send(message);// envia a msg

			System.out.println("Enviado!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
