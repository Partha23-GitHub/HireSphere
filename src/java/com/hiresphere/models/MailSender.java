/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.hiresphere.models;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.*;

//@Stateless
public class MailSender {

    static String fromEmail = "manna75partha@gmail.com";
    static String password = "sjhnmentjcxfepuv";
    static String userName = "manna75partha";

    public static void sendEmailToRegisterUser(String toEmail, String subject, String message) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "25");
            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password);
                }
            });

//            Session mailSession = Session.getInstance(properties, new Authenticator() {
//                @Override
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(userName, password);
//                }
//            });
            //mailSession.setDebug(true);
            Message mailMessage = new MimeMessage(session);

            //setting up all the messages
            mailMessage.setFrom(new InternetAddress(fromEmail));
            mailMessage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));
            mailMessage.setSubject(subject);
            mailMessage.setText(message);

            Transport.send(mailMessage);
            
        } catch (AddressException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

