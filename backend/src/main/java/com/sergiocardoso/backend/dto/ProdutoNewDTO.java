package com.sergiocardoso.backend.dto;

import javax.validation.constraints.NotEmpty;

public class ProdutoNewDTO {

	@NotEmpty(message = "Campo nome não pode ser vazio")
	private String name;
	private Double valor;
	private Integer quantidade;

	public ProdutoNewDTO() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
