package com.cubbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("emailService")
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    private String confirmLink = "http://localhost:8090/forgetpassword/confirm?token="+ UUID.randomUUID().toString();

    public void sendSimpleMessage(String to, String subject, String message) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText("Please click on the link to set reset password.\n"+message);
        emailSender.send(msg);
    }
}
