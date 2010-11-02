package mailer;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

// Send a simple, single part, text/plain e-mail
public class TestEmail {

    public static void main(String[] args) {

        // SUBSTITUTE YOUR EMAIL ADDRESSES HERE!!!
        String to = "nagraj.rao@sigmainfo.net";
        String from = "contact@blackwellsliveauction.com";
        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!
        String host = "mail.focusmailserver.com";

        // Create properties, get Session
        Properties props = new Properties();

        // If using static Transport.send(),
        // need to specify which host to send it to
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");//---Nagraj
	    props.put("mail.smtp.port", "25");//---Nagraj        
        props.put("mail.debug", "true");// To see what is going on behind the scene
        
        
        
        Authenticator authenticator = new org.apache.commons.mail.DefaultAuthenticator(from,"ecdyapye"); //password for commitee@blackwells...
      //Session session = Session.getInstance(props); // ----Nagraj
        Session session = Session.getInstance(props, authenticator);//authentication implied
        try {
            // Instantiatee a message
            Message msg = new MimeMessage(session);

            //Set message attributes
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("Test E-Mail through Java");
            msg.setSentDate(new Date());

            // Set message content
            msg.setText("This is a test of sending a " +
                        "plain text e-mail through Java.\n" +
                        "Here is line 2.");

            //Send the message
            Transport.send(msg);
        }
        catch (MessagingException mex) {
            // Prints all nested (chained) exceptions as well
            mex.printStackTrace();
        }
    }
}//End of class