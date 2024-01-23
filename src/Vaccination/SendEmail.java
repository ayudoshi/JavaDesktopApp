package Vaccination;

// Java program to send email

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
//import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;


public class SendEmail {

    public static int otp;

    SendEmail (String me, String s, String t, String f){

             System.out.println("Preparing...");
             Random ran = new Random();
             otp = ran.nextInt(1111, 10000);
             String message = ("Your OTP is :" + otp);
             String subject = "Password Reset.";
             new tomail();
             String to = tomail.uname;
             String from = "ayushkishordoshi@gmail.com";


            String host = "smtp.gmail.com";
            Properties properties = System.getProperties();
            System.out.println("Prop" + properties);

            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.ssl.enable", true);
            properties.put("mail.smtp.auth", true);

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("ayushkishordoshi@gmail.com", "wcmhnbchepeivgov" +
                            "");
                }
            });

            session.setDebug(true);

            MimeMessage m = new MimeMessage(session);
            try {
                m.setFrom(from);
                m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                m.setSubject(subject);
                m.setText(message);
                Transport.send(m);
                System.out.println("Success...");
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    public static void main(String[ ] arg){
        new SendEmail("a","b","c","d");

    }
}
