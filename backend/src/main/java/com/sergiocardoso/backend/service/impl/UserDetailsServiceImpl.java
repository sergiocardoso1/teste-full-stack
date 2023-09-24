package com.sergiocardoso.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sergiocardoso.backend.domain.Usuario;
import com.sergiocardoso.backend.repository.UsuarioRepository;
import com.sergiocardoso.backend.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = repository.findByEmail(email);
		if(usuario == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(usuario.getId(),usuario.getEmail(),usuario.getSenha(), usuario.getPerfis());
	}

}
