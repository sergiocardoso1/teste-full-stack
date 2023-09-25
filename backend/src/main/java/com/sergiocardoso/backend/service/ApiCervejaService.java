package com.sergiocardoso.backend.service;

import java.util.List;

import com.sergiocardoso.backend.domain.Cerveja;

public interface ApiCervejaService {
	
	public Cerveja findIdApi(Long id);

	public List<Cerveja> obterDadosApi();
	
	public List<Cerveja> obterDadosApiPorNome(String nome);
	
	
}
