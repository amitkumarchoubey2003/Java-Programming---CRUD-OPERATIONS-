package com.amity.sendEmail;

import java.io.File;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator; 
import javax.mail.Message; 
import javax.mail.MessagingException; 
import javax.mail.PasswordAuthentication; 
import javax.mail.Session; 
import javax.mail.Transport; 
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage; 
import javax.mail.internet.MimeMultipart;

public class Apps 
{
    public static void main( String[] args )
    {
        System.out.println("Hey Dear...Welcome to our mailing application");
        sendMail();
    }
    
    private static void sendMail() {
    	String msg = "Just checking dear, our mailing system";
    	String from = "arjunkumarchoubey7115@gmail.com";
    	String to = "prabhakark661@gmail.com";
    	String subject = "Our First Mail- Pranam Sir & How Are You Sir & I Hope that you are very well! ";
    	
    	//List out the different parameters for gmail
    	String host = "smtp.gmail.com";
    	String port = "465";
    	String ssl = "true";
    	String auth = "true";
    	
    	//Get System properties
    	Properties properties = System.getProperties();
//    	System.out.print("System Properties = "+properties);
    	
    	properties.put("mail.smtp.host", host);
    	properties.put("mail.smtp.port", port);
    	properties.put("mail.smtp.ssl.enable", ssl);
    	properties.put("mail.smtp.auth", auth);
    	
    	//Get the session object
    	Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("arjunkumarchoubey7115@gmail.com", "ycie bhhg szoe crqn");
			}
    		
    	});
    	session.setDebug(true);
    	
    	//compose message 
    	MimeMessage messageObject = new MimeMessage(session);
    	Address[] add = new Address[3];    	
    	
    	try {
    		add[0] = new InternetAddress("arjunkumarchoubey7115@gmail.com");
			add[1] = new InternetAddress("prabhakark661@gmail.com");
	    	add[2] = new InternetAddress("amitkumarchoubey2003@gmail.com");
	    	
	    	Address value = new InternetAddress("prabhakark661@gmail.com");
	    	Address value1 = new InternetAddress("amitkumarchoubey2003@gmail.com");
	    	messageObject.setFrom(new InternetAddress(from));
	    	messageObject.addRecipient(Message.RecipientType.CC,value); 
	    	messageObject.addRecipient(Message.RecipientType.BCC, value1);
	    	messageObject.setSubject(subject);

			
			
			
			MimeMultipart mimeMultipart = sendAttachments(msg);
			
			messageObject.setContent(mimeMultipart);
			
			Transport.send(messageObject);

			System.out.println("Mail sent successfully");
			
    	} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    private static MimeMultipart sendAttachments(String msg) {
    	File file = new File("C:\\Users\\AMIT\\OneDrive\\Desktop\\Apps.java");
		
		MimeMultipart mimeMultipart = new MimeMultipart();
		
		MimeBodyPart textContent = new MimeBodyPart();
		MimeBodyPart fileContent = new MimeBodyPart();
		
		try {
			
			textContent.setText(msg);
			fileContent.attachFile(file);
			
			mimeMultipart.addBodyPart(textContent);
			mimeMultipart.addBodyPart(fileContent);
			
		} catch(Exception e) {
			e.printStackTrace();	
		}
		return mimeMultipart;
    }

}