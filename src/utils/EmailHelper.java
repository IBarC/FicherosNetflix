package utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailHelper {
	
	static String email; //ratatasalvaje1dam@gmail.com //voladorapatata@gmail.com
	static String passwordEmail; //Pollofrit0! //Patata123!
	
	public static void sendForgotPassword(String to) {
		String subject = "Establece una contraseña nueva";
		String text = "Gracias por unirte a nuestra plataforma. Ahora puedes buscar shows nuevos para engancharte y no soltarlos.\n¡A disfrutar!";
		sendEmail(to, text, subject); 
	}
	
	public static void sendWelcome(String to) {
		String subject = "Bienvenido/a a Netflix :)";
		String text = "Gracias por unirte a nuestra plataforma. Ahora puedes buscar shows nuevos para engancharte y no soltarlos.\n¡A disfrutar!";
		sendEmail(to, text, subject);
	}
	
	public static void sendValidationCode(String to, String code) {
		String subject = "Valida tu cuenta";
		String text = code + " es el código que necesitas para validar tu cuenta con nosotros.";
		sendEmail(to, text, subject);
	}
	
	private static void sendEmail(String to, String text, String subject) {
		
		email=CredentialsHelper.readEmail();
		passwordEmail=CredentialsHelper.readPasswordrEmail();
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.trust", "*");
		prop.put("mail.smtp.starttls.required", "true");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, passwordEmail);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("a@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(text);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
