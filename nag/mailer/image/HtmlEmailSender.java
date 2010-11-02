package nag.mailer.image;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;






public class HtmlEmailSender {
	private static final	String	fqcn	=	HtmlEmailSender.class.getName();
	public	HtmlEmailSender(){
		
	}
	
	public static void main(String args[]){
		
		EmailMetaInfo emi = new EmailMetaInfo();
		 emi.setBodyText("testing images");		
		 emi.setFromEmail("demo@jbjgroup.in");
  	     emi.setHostName("mail.jbjgroup.in");  	     
  	     emi.setHostUserName("demo@jbjgroup.in");
	     emi.setHostPassword("demo");
	     emi.setReplyTo("nagraj.rao@sigmainfo.net");
	     emi.setSubjectMsg("imagetest");
	     emi.setAuthReqd(true);
	     emi.setFilePath("");//"D:\\eclipse\\workspace\\trials\\src\\mailer\\image\\nag.jpg");
	     ArrayList toList = new ArrayList();
	     toList.add("nagraj.rao@sigmainfo.net");	     
	     
	     HtmlEmailSender hes = new HtmlEmailSender();
		boolean flag	=	hes.sendHtmlEmail(toList, emi, true);
		System.out.println("status : "+flag);
	}
	
	/**
	 * This is the core method which does the sending of mails in html format.
	 * @param toList	List of strings containg all the to-email ids.
	 * @param emi	Object Containing all the metainfo about Email sending
	 * @param sendIndividual	This boolean flag represents if the mail needs to be sent individually to all "to-addressee"
	 */
	public boolean sendHtmlEmail(List toList, EmailMetaInfo emi, boolean sendIndividual){
		try {
			if(!sendIndividual){
				HtmlEmail	email	=	this.getEmailObject(emi);
				email.setTo(toList);
				email.send();
			}else{
				for(int i=0; i < toList.size(); i++){
					HtmlEmail	email	=	this.getEmailObject(emi);
					email.addTo((String)toList.get(i));
					email.send();
				}
			}
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			//SisLogger.log(fqcn,3815,"HtmlEmailSender::"+e.getMessage(),SisLogger.ERROR);
			System.out.println("==");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	private HtmlEmail getEmailObject(EmailMetaInfo	emi){
		HtmlEmail email = new HtmlEmail();
		EmailAttachment attachment = new EmailAttachment();
		try {
						
			email.setFrom(emi.getFromEmail());
			email.setHostName(emi.getHostName());
			email.setSubject(emi.getSubjectMsg());
			email.setHtmlMsg(emi.getBodyText());
			email.addReplyTo(emi.getReplyTo());	
			if(! emi.getFilePath().equals("")){
				attachment.setPath(emi.getFilePath());
				email.attach(attachment);
			}
			//email.setSmtpPort(465);
			
			String cid=email.embed(new URL("file:///D:/nag.jpg"),"test Logo");
			email.setHtmlMsg("<H1>Hi! From HtmlMailCommons</H1><img src=\"cid:"+cid+"\">");
			email.setTextMsg("Your email client does not support HTML messages, sorry");
			if(emi.isAuthReqd()){
				email.setAuthentication(emi.getHostUserName(),emi.getHostPassword());
			}
			System.out.println("came till here....");
		} catch (EmailException ee) {
			// TODO Auto-generated catch block
			//SisLogger.log(fqcn,3816,"HtmlEmailSender::"+e.getMessage(),SisLogger.ERROR);
			ee.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		return email;
	}
	public String sendHtmlEmail(String host, String from, String sendTo, String subject, String emailMessage, String string) {
		// TODO Auto-generated method stub
		return null;
	}

public String SendMail(String host, String from, String to, String subject, String msg, String filename) {

 	if (subject.equals(""))
	{
		subject = "NO SUBJECT SPECIFIED";
	}
	if (msg.equals(""))
	{
		msg = "NO MESSAGE SPECIFIED";
	}

	// Get system properties
	Properties props = System.getProperties();

	// Setup mail server
	props.put("mail.smtp.host", host);

	// Get session
	Session session = Session.getInstance(props, null);

	// Define message
	Message message = new MimeMessage(session);

	try {
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject);
	} catch (javax.mail.internet.AddressException ex){}
	  catch (javax.mail.MessagingException ex) {}
	// Create the message part
	BodyPart messageBodyPart = new MimeBodyPart();

	// Fill the message
	try {
		messageBodyPart.setText(msg);
	} catch (javax.mail.MessagingException ex) {}
	// Create a Multipart
	Multipart multipart = new MimeMultipart();

	try {
	// Add part one
		multipart.addBodyPart(messageBodyPart);
	} catch (javax.mail.MessagingException ex) {}
	//
	// Part two is attachment
	//

	// Create second body part
	messageBodyPart = new MimeBodyPart();

	// Get the attachment

	//----------Sandeep
	try{
		if (!filename.equals(""))
		{
			DataSource source = new FileDataSource(filename);
		
			// Set the data handler to the attachment
				messageBodyPart.setDataHandler(new DataHandler(source));

			// Set the filename
				messageBodyPart.setFileName(filename);

			// Add part two
				multipart.addBodyPart(messageBodyPart);

		} // End of code for attachement

			// Put parts in message
				message.setContent(multipart);


		// Send the message
			Transport.send(message);
		
		System.out.println("Message sent successfully");
		return "SUCCESS";
		} 
		catch (javax.mail.MessagingException ex) 
		{
			System.out.println("Message not sent successfully beacause of " + ex);
		}
		return "FAIL";
	
}

}
