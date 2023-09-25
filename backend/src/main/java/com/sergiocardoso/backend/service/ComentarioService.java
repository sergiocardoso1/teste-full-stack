package com.sergiocardoso.backend.service;

import java.util.List;

import com.sergiocardoso.backend.domain.Comentario;
import com.sergiocardoso.backend.dto.ComentarioDTO;
import com.sergiocardoso.backend.dto.ComentarioNewDTO;

public interface ComentarioService {
	
	public Comentario findId(Long id);
	
	public List<Comentario> buscarComentariosPorCervejaId(Long cervejaId);
	
	public Comentario insert(Comentario obj);
	
	public Comentario update(Comentario obj);
	
	public List<Comentario> findAll();
	
	public void delete(Long id);
	
	public Comentario fromDTO(ComentarioDTO objDto);
	
	public Comentario fromDTO(ComentarioNewDTO objDto);

}
