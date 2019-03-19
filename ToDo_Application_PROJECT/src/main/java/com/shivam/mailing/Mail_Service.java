package com.shivam.mailing;

/**
 * created by Shivam on 17-03-2019.
 */

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
public class Mail_Service {

    private static final String host ="smtp.gmail.com" ;
    private static final String user = "shivam.dev1097@gmail.com";
    private static final String pass = "12345";
    private static final String from = "shivam.dev1097@gmail.com";
    private static final String subject = "Reminder from VISION Technologies for your ToDo !";

    public static boolean sendMail(String recipient, String message){
        try{


            String to = recipient;

            String messageText =message;
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

//            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

            Transport transport=mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("message sent successfully");
            return true;
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
        return false;
    }



}