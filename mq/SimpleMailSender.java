/*
 * Created on Dec 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package mq;

/**
 * @author jip0i0
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import java.io.File;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class SimpleMailSender {

 public static void main(String[] args) {
 	
 	try{
 	
			JavaMailSenderImpl sender = new JavaMailSenderImpl();
			//int default_port =JavaMailSenderImpl.DEFAULT_PORT;
			//sender.setProtocol("smtp");
			sender.setHost("mail.jbjgroup.in");
			sender.setUsername("demo@jbjgroup.in");
			sender.setPassword("demo");
			System.out.println("added host name");
			Properties props = System.getProperties();
								props.put("mail.smtp.auth", "true");
			sender.setJavaMailProperties(props);
			
			MimeMessage mime = sender.createMimeMessage();
			
//			   use the true flag to indicate you need a multipart message
			MimeMessageHelper helper = new MimeMessageHelper(mime, true);
			
			
		//	String[] addresses = {"jigar.prajapati@gmail.com"};
			helper.setFrom(new InternetAddress("demo@jbjgroup.in"));
			
			helper.setTo(new InternetAddress("jigar.prajapati@gmail.com"));
			helper.setReplyTo(new InternetAddress("jigar.prajapati@gmail.com"));
			
			
			helper.setSubject("my subject");
		//	helper.setText("this is testing");
			helper.setText("<html><body>Dear Sir, <br> Good Morning, <br> This is test mail from Spring Mail API<b>This is bold text</b><br> <img src='cid:myLogo'></body></html>", true);
			FileSystemResource file1 = new FileSystemResource(new File ("C:\\Jigar\\testing\\Sample.jpg"));
			helper.addInline("myLogo",file1);
				FileSystemResource file = new FileSystemResource(new File ("C:\\Jigar\\testing\\basis.doc"));
			helper.addAttachment("sample.doc", file);
			System.out.println("created object");
				sender.send(mime);
 	}catch(MailException e1){
 		e1.printStackTrace();
 		System.out.println(e1);
 	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
}
 
}
