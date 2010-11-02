package mailer.image;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;






public class HtmlEmailSender {
	private static final	String	fqcn	=	HtmlEmailSender.class.getName();
	public	HtmlEmailSender(){
		
	}
	
	public static void main(String args[]){
		
//------------checking with demo@jbjgroup.in---------
//		
//		EmailMetaInfo emi = new EmailMetaInfo();
//		 emi.setBodyText("testing images");		
//		 emi.setFromEmail("demo@jbjgroup.in");
//  	     emi.setHostName("mail.jbjgroup.in");  	     
//  	     emi.setHostUserName("demo@jbjgroup.in");
//	     emi.setHostPassword("demo");
//		emi.setSmtpPortNumber(25);
//	     emi.setReplyTo("nagraj.rao@sigmainfo.net");
//	     emi.setSubjectMsg("imagetest");
//	     emi.setAuthReqd(true);
////	     emi.setFilePath("");//"D:\\eclipse\\workspace\\trials\\src\\mailer\\image\\nag.jpg");
//	     ArrayList toList = new ArrayList();
//	     toList.add("nagraj.rao@sigmainfo.net");
//		emi.setToList(toList);
//	     
//-------------Checking for blackwells
		
//	     EmailMetaInfo emi = new EmailMetaInfo();
//		 emi.setBodyText("testing images");		
//		 emi.setFromEmail("feedback@blackwellsliveauction.com");
//  	     emi.setHostName("mail.focusmailserver.com");  	     
//  	     emi.setHostUserName("feedback@blackwellsliveauction.com");
//	     emi.setHostPassword("phrozcha");
//		emi.setSmtpPortNumber(25);
//	     emi.setReplyTo("feedback@blackwellsliveauction.com");
//	     emi.setSubjectMsg("Mail Tester ");
//	     emi.setAuthReqd(true);
//	     //emi.setFilePath("");//D:\\eclipse\\workspace\\trials\\src\\mailer\\image\\nag.jpg");
//	     ArrayList toList = new ArrayList();
//	     toList.add("nagraj.rao@sigmainfo.net");	
//		emi.setToList(toList);
	
//-------------Checking for nettigritty
			
//	     EmailMetaInfo emi = new EmailMetaInfo();
//		 emi.setBodyText("testing images");		
//		 emi.setFromEmail("contact@blackwellsliveauction.com");
//  	     emi.setHostName("74.53.87.2");  	     
//  	     emi.setHostName("mail.blackwellsliveauction.com");
//  	     emi.setHostUserName("contact@blackwellsliveauction.com");
//	     emi.setHostPassword("contact123");
//		emi.setSmtpPortNumber(26);
//	     emi.setReplyTo("contact@blackwellsliveauction.com");
//	     emi.setSubjectMsg("Mail Tester ");
//	     emi.setAuthReqd(true);
//	     //emi.setFilePath("");//D:\\eclipse\\workspace\\trials\\src\\mailer\\image\\nag.jpg");
//	     ArrayList toList = new ArrayList();
//	     toList.add("nagraj.rao@sigmainfo.net");
//	     toList.add("vignesh@sigmainfo.net");
//		emi.setToList(toList);
	     
//-------------checking with gmail----------
	     
//	     EmailMetaInfo emi = new EmailMetaInfo();
//		 emi.setBodyText("testing mailer");		
//		 emi.setFromEmail("nagraj.rao@sigmainfo.net");
//  	     emi.setHostName("smtp.gmail.com");  	     
//  	     emi.setHostUserName("nagraj.rao@sigmainfo.net");		
//	     emi.setHostPassword("apache");
//		emi.setSmtpPortNumber(465);
//	     emi.setReplyTo("nagraj.rao@sigmainfo.net");
//	     emi.setSubjectMsg("Mail Tester ");
//	     emi.setAuthReqd(true);
//	     //emi.setFilePath("");//D:\\eclipse\\workspace\\trials\\src\\mailer\\image\\nag.jpg");
//	     ArrayList toList = new ArrayList();
//	     toList.add("nagraj.rao@sigmainfo.com");	
//		emi.setToList(toList);
	     
//-------------checking with captain mail / intermedia----------
	     
//	     EmailMetaInfo emi = new EmailMetaInfo();
//		 emi.setBodyText("testing mailer");		
//		 emi.setFromEmail("contact@blackwellsliveauction.com");
//  	     emi.setHostName("smtpx3.intermedia.net");  	     
//  	     emi.setHostUserName("contact@blackwellsliveauction.com");
//	     emi.setHostPassword("contact123");
//	     emi.setSmtpPortNumber(25);
//	     emi.setReplyTo("contact@blackwellsliveauction.com");
//	     emi.setSubjectMsg("Mail Tester on captain mails... ");
//	     emi.setAuthReqd(true);
//	     //emi.setFilePath("");//D:\\eclipse\\workspace\\trials\\src\\mailer\\image\\nag.jpg");
//	     ArrayList toList = new ArrayList();
//	     toList.add("nagraj.rao@sigmainfo.net");	
////	     toList.add("vignesh@sigmainfo.net");
//	     emi.setToList(toList);
	     	 
	     
//-------------checking with blackwells exchange  mail----------
	     
//	     EmailMetaInfo emi = new EmailMetaInfo();
//		 emi.setBodyText("testing mailer");		
//		 //emi.setFromEmail("sigma@blackwellsliveauction.com");
//		 emi.setFromEmail("blackwells@blackwellsliveauction.com");
//  	     emi.setHostName("mail.blackwellsliveauction.com");  	     
//  	     emi.setHostUserName("blackwells");
//	     emi.setHostPassword("14847USHighway1");
//	     emi.setSmtpPortNumber(25);
//	     emi.setReplyTo("noreply@blackwellsliveauction.com");
//	     emi.setSubjectMsg("Mail Tester on Blackwells Exchange server... ");
//	     emi.setAuthReqd(true);
//	     //emi.setFilePath("");//D:\\eclipse\\workspace\\trials\\src\\mailer\\image\\nag.jpg");
//	     ArrayList toList = new ArrayList();
//	     toList.add("nagraj.rao@sigmainfo.net");	
//	     //toList.add("vignesh@sigmainfo.net");
//	     emi.setToList(toList);
	     
//--------------checking for LSM------------------------
//	     EmailMetaInfo emi = new EmailMetaInfo();
//		 emi.setBodyText("testing mailer");		
//		 //emi.setFromEmail("sigma@blackwellsliveauction.com");
//		 emi.setFromEmail("test@sigmainfo.in");
//  	     emi.setHostName("mail.sigmainfo.in");  	     
//  	     emi.setHostUserName("test@sigmainfo.in");
//	     emi.setHostPassword("sigma123");
//	     emi.setSmtpPortNumber(25);
//	     emi.setReplyTo("noreply@sigmainfo.in");
//	     emi.setSubjectMsg("Mail Tester on Blackwells Exchange server... ");
//	     emi.setAuthReqd(true);
//	     //emi.setFilePath("");//D:\\eclipse\\workspace\\trials\\src\\mailer\\image\\nag.jpg");
//	     ArrayList toList = new ArrayList();
//	     toList.add("nagraj.rao@sigmainfo.net");	
//	     //toList.add("vignesh@sigmainfo.net");
//	     emi.setToList(toList);
//	     
//-----------Surgery planet-----------------
	     EmailMetaInfo emi = new EmailMetaInfo();
		 emi.setBodyText("testing mailer");		
		 //emi.setFromEmail("sigma@blackwellsliveauction.com");
		 emi.setFromEmail("pport@surgeryplanet.net");//crm@surgeryplanet.com");		  
  	     emi.setHostName("s2smtpout.secureserver.net");  	     
  	     emi.setHostUserName("pport@surgeryplanet.com");
	     emi.setHostPassword("support$123");//surgeryplanetcrm");
	     emi.setSmtpPortNumber(25);
	     emi.setReplyTo("noreply@sigmainfo.in");
	     emi.setSubjectMsg("Mail Tester on Surgeryplanet server... ");
	     emi.setAuthReqd(false);
	     //emi.setFilePath("");//D:\\eclipse\\workspace\\trials\\src\\mailer\\image\\nag.jpg");
	     ArrayList toList = new ArrayList();
	     toList.add("crm@surgeryplanet.com");//nagraj.rao@sigmainfo.net");	
	     //toList.add("vignesh@sigmainfo.net");
	     emi.setToList(toList);
	     
//--------------------------------------------------	     
	    int type=1;//2 for commons mail
	    HtmlEmailSender hes = new HtmlEmailSender();
	    
		if(type==1){
			//sending thru usual javaMail api
			hes.sendMail(emi);
		}else{
		    
			boolean flag	=	hes.sendHtmlEmail(emi, true);
			System.out.println("status : "+flag);
		}
	}
	
	/**
	 * This is the core method which does the sending of mails in html format.
	 * @param toList	List of strings containg all the to-email ids.
	 * @param emi	Object Containing all the metainfo about Email sending
	 * @param sendIndividual	This boolean flag represents if the mail needs to be sent individually to all "to-addressee"
	 */
	public boolean sendHtmlEmail(EmailMetaInfo emi, boolean sendIndividual){
		try {
			if(!sendIndividual){
				HtmlEmail	email	=	this.getEmailObject(emi);
				email.setTo(emi.getToList());
				System.out.println("Sending the mail now...");
				email.send();
				System.out.println("Mail sent...");
			}else{
				ArrayList toList = (ArrayList)emi.getToList();
				for(int i=0; i < toList.size(); i++){
					HtmlEmail	email	=	this.getEmailObject(emi);					
					email.setAuthentication(emi.getHostUserName(), emi.getHostPassword());					
					email.addTo((String)toList.get(i));
					System.out.println("Sending the mail now...");
					email.send();
					System.out.println("Mail sent...");
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
		
		//--------------------
		Properties props = new Properties();
		
		// Setup mail server			
		props.put("mail.smtp.host", emi.getHostName());
	    props.put("mail.smtp.auth", emi.isAuthReqd()? "true" : "false");
	    props.put("mail.smtp.port", emi.getSmtpPortNumber());
//	    props.put("mail.smtp.starttls.enable","true");
//	    props.put("mail.smtp.relay","true");
//	    props.put("mail.smtp.ssl","true");
	    props.put("mail.debug", "true");// To see what is going on behind the scene        
	
        // creating an Authenticator and setting up
		Authenticator authenticator = new org.apache.commons.mail.DefaultAuthenticator(emi.getHostUserName(),emi.getHostPassword());
		// Get session
	    Session session = Session.getInstance(props, authenticator);
		
		
		//------------------------
		
		
		try {
			System.out.println("Authentication required  ============>"+emi.isAuthReqd());
			if(emi.isAuthReqd()){				
				email.setAuthentication(emi.getHostUserName(),emi.getHostPassword());
				System.out.println("Authentication successfull....loading other props...");
			}
			email.setAuthenticator(authenticator);
			email.setMailSession(session);
			email.setFrom(emi.getFromEmail());
			email.setHostName(emi.getHostName());
			email.setSubject(emi.getSubjectMsg());
			email.setHtmlMsg(emi.getBodyText());
			email.addReplyTo(emi.getReplyTo());	
			if(emi.getFilePath()!=null && !emi.getFilePath().equals("")){
				attachment.setPath(emi.getFilePath());
				email.attach(attachment);
			}
			if(emi.getSmtpPortNumber()!= 0){
				email.setSmtpPort(emi.getSmtpPortNumber());
			}else{
				email.setSmtpPort(25); //defaulting it
			}
			
			

//			String cid=email.embed(new URL("file:///D:/nag.jpg"),"test Logo");
//			email.setHtmlMsg("<H1>Hi! From HtmlMailCommons</H1><img src=\"cid:"+cid+"\">");
//			email.setTextMsg("Your email client does not support HTML messages, sorry");
					
		} catch (EmailException ee) {			
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

	public String sendMail(EmailMetaInfo emi) {	
	 	
		// Get system properties
		//Properties props = System.getProperties();
		Properties props = new Properties();
		
		// Setup mail server			
		props.put("mail.smtp.host", emi.getHostName());
	    props.put("mail.smtp.auth", emi.isAuthReqd()? "true" : "false");
	    props.put("mail.smtp.port", emi.getSmtpPortNumber());
	    props.put("mail.smtp.starttls.enable","true");
	    props.put("mail.smtp.ssl","true");
        props.put("mail.debug", "true");// To see what is going on behind the scene        
	
        // creating an Authenticator and setting up
		Authenticator authenticator = new org.apache.commons.mail.DefaultAuthenticator(emi.getHostUserName(),emi.getHostPassword());
		// Get session
	    Session session = Session.getInstance(props, authenticator);
		// Session session = Session.getInstance(props, null);
	    System.out.println("----------------------------------------------->>>>>>>>>>>>>>>>>>");
		// Define message
		Message message = new MimeMessage(session);
	
		try {
			message.setFrom(new InternetAddress(emi.getFromEmail()));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("crm@surgeryplanet.com"));
			//message.addRecipient(Message.RecipientType.TO, new InternetAddress("contact@blackwellsliveauction.com"));
			message.setSubject(emi.getSubjectMsg());
			message.setSentDate(new Date());
			message.setText("Testing the mail sender thru normal text");
		} catch (javax.mail.internet.AddressException ex){
			ex.printStackTrace();
		} catch (javax.mail.MessagingException ex) {
			ex.printStackTrace();
		}
		
		/*
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
		} catch (javax.mail.MessagingException ex) {
			ex.printStackTrace();
		}
		*///----------
		try{
			/*------------------
		This is for the attachments
		// Part two is attachment
		//
	
		// Create second body part
		messageBodyPart = new MimeBodyPart();
	
		// Get the attachment	
		
			if (!filename.equals("")){
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
	
*/	
			// Send the message
			Transport.send(message);
			
			System.out.println("Message sent successfully");
			return "SUCCESS";
		}catch (javax.mail.MessagingException ex){
			System.out.println("Message not sent successfully beacause of " + ex);
			ex.printStackTrace();
		}
		return "FAIL";	
	}

}
