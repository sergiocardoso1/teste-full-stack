package com.sergiocardoso.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sergiocardoso.backend.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	

}
