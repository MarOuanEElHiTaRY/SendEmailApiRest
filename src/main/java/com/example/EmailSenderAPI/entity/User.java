package com.example.EmailSenderAPI.entity;

import lombok.Data;

@Data
public class User {
	private String firstName;
	private String lastName;
	private String email;
	private String text;
	private String subject;

}
