package com.example.EmailSenderAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.EmailSenderAPI.entity.User;

@Service
public class NotificationSender {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendNotification(User user) throws MailException{

		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setTo(user.getEmail());
		mail.setFrom("youssef.nafaa93@gmail.com");
		mail.setSubject(user.getSubject());
		mail.setText(user.getText());

		javaMailSender.send(mail);
		
	}

}
