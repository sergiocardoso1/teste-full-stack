package com.sergiocardoso.backend.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sergiocardoso.backend.domain.Usuario;
import com.sergiocardoso.backend.domain.enums.Perfil;
import com.sergiocardoso.backend.dto.UsuarioDTO;
import com.sergiocardoso.backend.dto.UsuarioNewDTO;
import com.sergiocardoso.backend.dto.UsuarioPasswordDTO;
import com.sergiocardoso.backend.repository.UsuarioRepository;
import com.sergiocardoso.backend.service.UsuarioService;
import com.sergiocardoso.backend.service.exceptions.ObjectNotFoundException;


@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UsuarioRepository repository;

	public Usuario findId(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	@Override
	public Usuario findEmail(String email) {
		Usuario usuario = repository.findByEmail(email);
		if (usuario == null) {
			throw new NoSuchElementException("Email não existe!" + email);
		}
		return usuario;
	}

	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Usuario update(Usuario obj) {
		Usuario newObj = findId(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	@Override
	public Usuario passwordUpdate(Usuario obj) {
		Usuario newObj = findId(obj.getId());
		updateDataPassword(newObj, obj);
		return repository.save(newObj);
	}

	public void delete(Long id) {
		findId(id);
		repository.deleteById(id);
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public void updateData(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
	}

	public void updateDataPassword(Usuario newObj, Usuario obj) {
		newObj.setSenha(obj.getSenha());
	}

	public Usuario fromDTO(UsuarioNewDTO objDto) {
		Usuario obj = new Usuario(null, objDto.getNome(), objDto.getEmail(),
				bCryptPasswordEncoder.encode(objDto.getSenha()));
		if (objDto.getPerfil() != null) {
			obj.addPerfil(Perfil.toEnum(objDto.getPerfil()));
		}
		return obj;
	}

	public Usuario fromDTO(UsuarioDTO objDto) {
		Usuario obj = new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail(), null);
		if (objDto.getPerfil() != null) {
			obj.addPerfil(Perfil.toEnum(objDto.getPerfil()));
		}
		return obj;
	}

	@Override
	public Usuario fromDTO(UsuarioPasswordDTO objDto) {
		Usuario obj = new Usuario(objDto.getId(), null, null, bCryptPasswordEncoder.encode(objDto.getVelhaSenha()));
		if (bCryptPasswordEncoder.matches(objDto.getVelhaSenha(), findId(objDto.getId()).getSenha()) == true) {
			obj.setSenha(bCryptPasswordEncoder.encode(objDto.getNovaSenha()));

		}

		return obj;
	}

}
