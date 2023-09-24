package com.sergiocardoso.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergiocardoso.backend.domain.Produto;
import com.sergiocardoso.backend.dto.ProdutoDTO;
import com.sergiocardoso.backend.dto.ProdutoNewDTO;
import com.sergiocardoso.backend.repository.ProdutoRepository;
import com.sergiocardoso.backend.service.ProdutoService;
import com.sergiocardoso.backend.service.exceptions.ObjectNotFoundException;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Override
	public Produto findId(Long id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	@Override
	public Produto insert(Produto obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	@Override
	public Produto update(Produto obj) {
		Produto newObj = findId(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	@Override
	public List<Produto> findAll() {
		return repository.findAll();
	}

	@Override
	public void delete(Long id) {
		findId(id);
		repository.deleteById(id);

	}
	
	private void updateData(Produto newObj, Produto obj) {
		newObj.setName(obj.getName());
		newObj.setQuantidade(obj.getQuantidade());
		newObj.setValor(obj.getValor());
	}

	@Override
	public Produto fromDTO(ProdutoDTO objDto) {
		Produto obj = new Produto(objDto.getId(), objDto.getName(), objDto.getValor(), objDto.getQuantidade());
		return obj;
	}

	@Override
	public Produto fromDTO(ProdutoNewDTO objDto) {
		Produto obj = new Produto(null, objDto.getName(), objDto.getValor(), objDto.getQuantidade());
		return obj;
	}

}
