package com.sergiocardoso.backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sergiocardoso.backend.domain.Cerveja;
import com.sergiocardoso.backend.service.ApiCervejaService;

@RestController
@RequestMapping("/cervejas")
public class ApiCervejaController {

	@Autowired
	private ApiCervejaService apiCervejaService;
	
	@Autowired
	public ApiCervejaController(ApiCervejaService apiCervejaService) {
		this.apiCervejaService = apiCervejaService;
	}
	
	@RequestMapping(method =  RequestMethod.GET)
	public List<Cerveja> obterDadosExternos() {
		return apiCervejaService.obterDadosApi();
	}
	
	@RequestMapping(value = "/buscarpornome",method =  RequestMethod.GET)
	public List<Cerveja> obterDadosExternos(@RequestParam(value = "nome") @Valid String nome) {
		return apiCervejaService.obterDadosApiPorNome(nome);
	}
	

	
}
