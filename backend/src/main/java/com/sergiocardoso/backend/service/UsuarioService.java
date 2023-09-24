package com.sergiocardoso.backend.service;

import java.util.List;

import com.sergiocardoso.backend.domain.Usuario;
import com.sergiocardoso.backend.dto.UsuarioDTO;
import com.sergiocardoso.backend.dto.UsuarioNewDTO;
import com.sergiocardoso.backend.dto.UsuarioPasswordDTO;

public interface UsuarioService {

	public Usuario findId(Long id);

	public Usuario findEmail(String email);

	public Usuario insert(Usuario obj);

	public Usuario update(Usuario obj);

	public Usuario passwordUpdate(Usuario obj);

	public List<Usuario> findAll();

	public void delete(Long id);

	public Usuario fromDTO(UsuarioDTO objDto);

	public Usuario fromDTO(UsuarioNewDTO objDto);

	public Usuario fromDTO(UsuarioPasswordDTO objDto);
}
