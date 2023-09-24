package com.sergiocardoso.backend.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sergiocardoso.backend.domain.Usuario;
import com.sergiocardoso.backend.dto.UsuarioDTO;
import com.sergiocardoso.backend.dto.UsuarioNewDTO;
import com.sergiocardoso.backend.dto.UsuarioPasswordDTO;
import com.sergiocardoso.backend.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> findId(@PathVariable Long id){
		Usuario obj = service.findId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping("/email/{email}")
    public ResponseEntity<Usuario> findByName(@PathVariable String email) {
        Usuario obj = service.findEmail(email);
        return ResponseEntity.ok().body(obj);
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Usuario> insert(@Valid @RequestBody UsuarioNewDTO objDto){
		Usuario obj = service.fromDTO(objDto);
		obj.setId(null);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> update(@Valid @RequestBody UsuarioDTO objDto, @PathVariable Long id){
		Usuario obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/updatepassword/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> updatePassword(@Valid @RequestBody UsuarioPasswordDTO objDto, @PathVariable Long id){
		Usuario obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.passwordUpdate(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
