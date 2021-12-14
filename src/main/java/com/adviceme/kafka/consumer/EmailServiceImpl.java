package com.adviceme.kafka.consumer;

import com.adviceme.kafka.consumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailServiceImpl{

    @Autowired
    private final JavaMailSender emailSender;

    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(User msg) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(msg.email());
        message.setSubject("Sing up successfully");
        message.setText("Thanks to sign up to our application, " + msg.firstName() + " " + msg.lastName());
        emailSender.send(message);
    }

}
