package com.sergiocardoso.backend.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sergiocardoso.backend.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Transactional()
	Usuario findByEmail(String email);
}
