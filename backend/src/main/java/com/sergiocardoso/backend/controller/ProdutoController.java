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

import com.sergiocardoso.backend.domain.Produto;
import com.sergiocardoso.backend.dto.ProdutoDTO;
import com.sergiocardoso.backend.dto.ProdutoNewDTO;
import com.sergiocardoso.backend.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> findId(@PathVariable Long id) {
		Produto obj = service.findId(id);
		return ResponseEntity.ok().body(obj);
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Produto> insert(@Valid @RequestBody ProdutoNewDTO objDto) {
		Produto obj = service.fromDTO(objDto);
		obj.setId(null);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Produto> update(@Valid @RequestBody ProdutoDTO objDto, @PathVariable Long id) {
		Produto obj = service.fromDTO(objDto);
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
