package com.sergiocardoso.backend.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sergiocardoso.backend.domain.Usuario;

@Service
public class EmailService {
	
	@Value("${spring.mail.username}")
	private String sender;
	
	@Autowired
    private JavaMailSender emailSender;
	

	public void sendNewPasswordEmail(Usuario usuario, String newPass) {
		 SimpleMailMessage message = prepareNewPasswordEmail(usuario, newPass);
		 emailSender.send(message);
		 
	}

	protected SimpleMailMessage prepareNewPasswordEmail(Usuario usuario, String newPass) {
		 SimpleMailMessage message = new SimpleMailMessage();
         message.setFrom(sender);
         message.setTo(usuario.getEmail());
         message.setSubject("Solicitacao de nova senha");
         message.setSentDate(new Date(System.currentTimeMillis()));
         message.setText("Nova senha: " + newPass);
         return message;
	}
}
