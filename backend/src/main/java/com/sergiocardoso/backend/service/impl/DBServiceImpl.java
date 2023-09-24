package com.sergiocardoso.backend.service.impl;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sergiocardoso.backend.domain.Usuario;
import com.sergiocardoso.backend.repository.UsuarioRepository;

@Service
@Component
public class DBServiceImpl {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public void instantiateTestDatabase() throws ParseException {
		
		Usuario user = new Usuario(null, "Sérgio", "sergiocardosodeveloper@gmail.com", bCryptPasswordEncoder.encode("123456"));
		usuarioRepository.save(user);
	
	}

}