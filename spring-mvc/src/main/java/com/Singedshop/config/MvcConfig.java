package com.Singedshop.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.Singedshop")
public class MvcConfig {
	
	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender  = new JavaMailSenderImpl();
		
		//Using gmail
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("huynhminhquan07072002@gmail.com");
		mailSender.setPassword("fwvrrthyewfbosin");
		
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.debug", "true");  // Hiển thị mọi thứ
		
		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
		
	}
}
