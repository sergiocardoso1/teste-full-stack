package com.sergiocardoso.backend.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sergiocardoso.backend.domain.Usuario;
import com.sergiocardoso.backend.repository.UsuarioRepository;
import com.sergiocardoso.backend.service.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if(usuario == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		String newPass = newPassword();
		usuario.setSenha(bCryptPasswordEncoder.encode(newPass));
		usuarioRepository.save(usuario);
		emailService.sendNewPasswordEmail(usuario, newPass);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for(int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if(opt == 0) {
			return (char) (rand.nextInt(10) + 48);
		}
		else if(opt == 1) {
			return (char) (rand.nextInt(26) + 65);
		}
		else {
			return (char) (rand.nextInt(26) + 97);
		}
	}
}
