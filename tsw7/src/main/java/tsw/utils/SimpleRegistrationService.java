package tsw.utils;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import tsw.domain.Users;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
/*  RegistrationTemplate.txt
		<html><head></head><body>
		<h3>Hi ${user.username}, welcome to Team Sportsware!</h3>
		<div>
		   Your email address is <a href="mailto:${user.username}">${user.username}</a>.
		</div>
		</body></html>
 */
public class SimpleRegistrationService {

   private JavaMailSender mailSender;
   private VelocityEngine velocityEngine;

   public void setMailSender(JavaMailSender mailSender) {
      this.mailSender = mailSender;
   }

   public void setVelocityEngine(VelocityEngine velocityEngine) {
      this.velocityEngine = velocityEngine;
   }

   public void register(Users user) {
      // Do the registration logic...
      sendConfirmationEmail(user);
   }

   private void sendConfirmationEmail(final Users user) {
      MimeMessagePreparator preparator = new MimeMessagePreparator() {
         @Override
		public void prepare(MimeMessage mimeMessage) throws Exception {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setTo(user.getUsername());
            message.setFrom("service@simplyt3s.com"); // could be parameterized...
            Map<String,Users> model = new HashMap<String,Users>();
            model.put("user", user);
            String text = VelocityEngineUtils.mergeTemplateIntoString(
               velocityEngine, "tsw/utils/RegistrationTemplate.txt", model);
            message.setText(text, true);
         }
      };
      this.mailSender.send(preparator);
   }
}
