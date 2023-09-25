package com.sergiocardoso.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sergiocardoso.backend.domain.Cerveja;
import com.sergiocardoso.backend.service.ApiCervejaService;
import com.sergiocardoso.backend.service.exceptions.ObjectNotFoundException;

@Service
public class ApiCervejaServiceImpl implements ApiCervejaService{
	
	private final RestTemplate restTemplate;
	
	private String url = "https://api.punkapi.com/v2/beers/";
	
	
	@Autowired
	public ApiCervejaServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public Cerveja findIdApi(Long id) {
	    String urlComNome = url + id.toString();
	    ResponseEntity<List<Cerveja>> responseEntity = restTemplate.exchange(
	            urlComNome,
	            HttpMethod.GET,
	            null,
	            new ParameterizedTypeReference<List<Cerveja>>() {}
	    );

	    List<Cerveja> cervejas = responseEntity.getBody();
	    Optional<Cerveja> cervejaOptional = cervejas.stream().findFirst();

	    return cervejaOptional.orElseThrow(() -> new ObjectNotFoundException(
	            "Objeto não encontrado. Id: " + id + ", Tipo: " + Cerveja.class.getName()));
	}
	
	public List<Cerveja> obterDadosApi() {
		ResponseEntity<List<Cerveja>> responseEntity = restTemplate.exchange(
				url,
	            HttpMethod.GET,
	            null,
	            new ParameterizedTypeReference<List<Cerveja>>() {}
	        );
		return responseEntity.getBody();
	}
	
	public List<Cerveja> obterDadosApiPorNome(String nome) {
		String urlComNome = url + "?beer_name=" + nome;
		ResponseEntity<List<Cerveja>> responseEntity = restTemplate.exchange(
				urlComNome,
	            HttpMethod.GET,
	            null,
	            new ParameterizedTypeReference<List<Cerveja>>() {}
	        );
		return responseEntity.getBody();
	}
	
	
}
