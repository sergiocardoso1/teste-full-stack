package com.sergiocardoso.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sergiocardoso.backend.domain.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
	
	@Query("SELECT c FROM Comentario c WHERE c.cervejaId = :cervejaId")
    List<Comentario> findComentariosByCervejaId(Long cervejaId);
}
