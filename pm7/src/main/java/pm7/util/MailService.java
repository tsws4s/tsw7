package pm7.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// import org.apache.commons.mail.HtmlEmail;

//TODO [Tim]: import org.apache.commons.mail.HtmlEmail;
// import org.springframework.ui.velocity.VelocityEngineUtils;
// import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import org.springframework.mail.javamail.JavaMailSender;


import pm7.domain.User;

@SuppressWarnings("unused")

@Service("mailService")
public class MailService {

    @Autowired
    private JavaMailSender mailSender;
    private TaskExecutor taskExecutor;

    public void setMailSender(JavaMailSender mailSender) {
      this.mailSender = mailSender;
    }
    
    @Async
    public void sendMail(String from, String to, String subject, String body) {
    	sendMail(from, null, to, null, subject, body, null);
    }
       
   @Async
   //TODO [Veera]: Mail logos and attachments,  http://commons.apache.org/proper/commons-email/userguide.html
    public void sendMail(String fromEmail, String fromName, String toEmail, String toName, String subject, String body, String attachment) {
    	
    	final String username = "service@simplyt3s.com";
		final String password = "bauer123";
		final String defaultFromName = "Customer Service";
		if(fromEmail==null || fromEmail.length()<1){
			fromEmail = username;
		}
		if(fromName==null || fromName.length()<1){
			fromName = defaultFromName;
		}
		if(toName==null || toName.length()<1){
			toName = toEmail;
		}
		if(attachment!=null){
			// note: use email with attachment?
		}
		
		try{
			// Create the email message
			//TODO [Tim]: 
/**
			HtmlEmail email = new HtmlEmail();
			  email.setAuthentication(username,password);
			  email.setCharset("utf-8");
			  email.setSmtpPort(587);
			  email.setTLS(true);
			  email.setHostName("smtp.gmail.com");
			  
			  
			  email.addTo(toEmail, toName);
			  email.setFrom(fromEmail, fromName);
			  email.setSubject(subject);
			  email.setHtmlMsg(body);
			  email.send();
*/
		}catch (Exception e) {
			e.printStackTrace();
		}
    	
  	  }    	
}