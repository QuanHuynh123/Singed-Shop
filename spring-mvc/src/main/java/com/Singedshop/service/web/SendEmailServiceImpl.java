package com.Singedshop.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class SendEmailServiceImpl {
	
	
	@Autowired
	MailSender mailSender;
	
	public void sendEmail(String from , String to , String subject , String content) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(content);
		
		mailSender.send(mailMessage);
	}
}
