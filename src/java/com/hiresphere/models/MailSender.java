/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.hiresphere.models;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * @author user 
 * This class is responsible for sending mail to the users.
 */
public class MailSender {

    static String fromEmail = "manna75partha@gmail.com";
    static String password = "sjhnmentjcxfepuv";
    static String userName = "manna75partha";

    /**
     *
     * @param toEmail
     * @param subject
     * @param message
     * This method is basically configure all the SMTP protocols
     * then create the mail session takes input from the view for getting the
     * recipient address and send the email with the predefined Subject,Message
     * Body etc.
     */
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
