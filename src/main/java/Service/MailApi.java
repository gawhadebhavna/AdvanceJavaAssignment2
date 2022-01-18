package Service;
import java.lang.*;
import java.util.Properties;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailApi {



    public static void email(String email) throws MessagingException {

        String message = "Welcome,Thank you for the registration. Please don't reply this message for security purpose..Khushh rhooooooo";
        String subject = "For confirmation";
        String to = email;
        String from = "bhavna.gawhade@hotwaxsystems.com";

        sendEmail(message, subject, to, from);



    }
    // this method is responsible for send message
    private static void sendEmail(String message, String subject, String to, String from) {
        // variable for gmail
        String host ="smtp.gmail.com";

        //get the system properties
        Properties  properties =System.getProperties();
        System.out.println("Properties"+ properties);

        //setting important information
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        //to get the session object
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){

                return  new PasswordAuthentication("bhavna.gawhade@hotwaxsystems.com","Bhavi12@#");
            }
        });

        session.setDebug(true);

        // compose the message
        MimeMessage mime = new MimeMessage(session);


        try {
            // from email
            mime.setFrom(from);

            //adding recipient to message
            mime.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

            //adding subject to message
            mime.setSubject(subject);

            //adding text to message
            mime.setText(message);

            //send the message using transportclass
            Transport.send(mime);

            System.out.println("Sent successfully....");


        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }


    }
}