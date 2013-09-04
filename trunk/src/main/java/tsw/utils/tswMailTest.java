package tsw.utils;

	import java.util.Properties;
	 
	import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;
	 
	public class tswMailTest {
	 
		public static void main(String[] args) {
	 
			final String username = "service@simplyt3s.com";
			final String password = "bauer123";
	 
			final Properties props = new Properties();
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
			String key="al1sk3fj5";
			String path="http://tsws4s.com/tsw7"; // request.getPathTranslated()
			try {
	 
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress("tim@simplyt3s.com"));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("service@simplyt3s.com"));
				message.setSubject("Team Sportsware - Reset Password");
				StringBuffer msg = new StringBuffer();	
				msg.append("<html><head></head><body>");
				msg.append("<p>You have requested to change your password.</p>");
				msg.append("<p> </p>");
				msg.append("<p><a href='"+path+"/changePassword?emailAddr="+"tim@simplyt3s.com"+"&key="+key+"'>Click here</a> to reset the password.</p>");
				msg.append("<p> </p>");
				msg.append("<p>Sincerely,</p>");
				msg.append("<p> </p>");
				msg.append("<p>Your friends at Team Sportsware</p>");
				msg.append("</body></html>");
		        message.setContent(msg.toString(), "text/html" );
		        
				Transport.send(message);
	 
				System.out.println("Done");
	 
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
	}
