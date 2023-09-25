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

import com.sergiocardoso.backend.domain.Comentario;
import com.sergiocardoso.backend.dto.ComentarioDTO;
import com.sergiocardoso.backend.dto.ComentarioNewDTO;
import com.sergiocardoso.backend.service.ComentarioService;

@RestController
@RequestMapping(value = "/comentarios")
public class ComentarioController {

	@Autowired
	private ComentarioService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Comentario> findId(@PathVariable Long id) {
		Comentario obj = service.findId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/cerveja/{cervejaId}" ,method = RequestMethod.GET)
	public ResponseEntity<List<Comentario>> findComentariosByCervejaId(@PathVariable Long cervejaId) {
        List<Comentario> comentarios = service.buscarComentariosPorCervejaId(cervejaId);
        return ResponseEntity.ok().body(comentarios);
    }
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Comentario>> findAll() {
		List<Comentario> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Comentario> insert(@Valid @RequestBody ComentarioNewDTO objDto) {
		Comentario obj = service.fromDTO(objDto);
		obj.setId(null);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Comentario> update(@Valid @RequestBody ComentarioDTO objDto, @PathVariable Long id) {
		Comentario obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	
}
