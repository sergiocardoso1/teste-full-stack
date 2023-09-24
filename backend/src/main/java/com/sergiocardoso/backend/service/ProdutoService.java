package com.sergiocardoso.backend.service;

import java.util.List;

import com.sergiocardoso.backend.domain.Produto;
import com.sergiocardoso.backend.dto.ProdutoDTO;
import com.sergiocardoso.backend.dto.ProdutoNewDTO;

public interface ProdutoService {
	
	public Produto findId(Long id);
	
	public Produto insert(Produto obj);
	
	public Produto update(Produto obj);
	
	public List<Produto> findAll();
	
	public void delete(Long id);
	
	public Produto fromDTO(ProdutoDTO objDto);
	
	public Produto fromDTO(ProdutoNewDTO objDto);

}
