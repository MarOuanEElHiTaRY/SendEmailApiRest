package com.example.EmailSenderAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmailSenderAPI.entity.User;
import com.example.EmailSenderAPI.service.NotificationSender;

@RestController

@CrossOrigin("*")
public class EmailController {
	@Autowired
	private NotificationSender notificationSender;

	@RequestMapping("/email")
	@GetMapping()
	public String msg(@RequestBody User user) {
		
		try {
			notificationSender.sendNotification(user);
		} catch (MailException e) {
			System.out.println(e.getMessage());

		}
		return "success d'envoi de la part de : "+user.getEmail();
	}
}
