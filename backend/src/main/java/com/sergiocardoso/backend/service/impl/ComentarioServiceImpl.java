package com.sergiocardoso.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergiocardoso.backend.domain.Comentario;
import com.sergiocardoso.backend.dto.ComentarioDTO;
import com.sergiocardoso.backend.dto.ComentarioNewDTO;
import com.sergiocardoso.backend.repository.ComentarioRepository;
import com.sergiocardoso.backend.service.ApiCervejaService;
import com.sergiocardoso.backend.service.ComentarioService;
import com.sergiocardoso.backend.service.exceptions.ObjectNotFoundException;

@Service
public class ComentarioServiceImpl implements ComentarioService {

	@Autowired
	private ComentarioRepository repository;
	
	@Autowired
	private ApiCervejaService apiCervejaService;

	@Override
	public Comentario findId(Long id) {
		Optional<Comentario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. Id: " + id + ", Tipo: " + Comentario.class.getName()));
	}
	
	@Override
	public List<Comentario> buscarComentariosPorCervejaId(Long cervejaId) {
        return repository.findComentariosByCervejaId(cervejaId);
    }

	@Override
	public Comentario insert(Comentario obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	@Override
	public Comentario update(Comentario obj) {
		Comentario newObj = findId(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	@Override
	public List<Comentario> findAll() {
		return repository.findAll();
	}

	@Override
	public void delete(Long id) {
		findId(id);
		repository.deleteById(id);

	}
	
	private void updateData(Comentario newObj, Comentario obj) {
		newObj.setComentario(obj.getComentario());
	
	}

	@Override
	public Comentario fromDTO(ComentarioDTO objDto) {
		Comentario obj = new Comentario(objDto.getId(), objDto.getComentario(), objDto.getCervejaId());
		return obj;
	}

	@Override
	public Comentario fromDTO(ComentarioNewDTO objDto) {
		apiCervejaService.findIdApi(objDto.getCervejaId());
		Comentario obj = new Comentario(null, objDto.getComentario(), objDto.getCervejaId());
		return obj;
	}

}
