package com.sergiocardoso.backend.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UsuarioNewDTO {
	
	@NotEmpty(message =  "O campo nome não pode ser vazio")
	@Length(min=2, max=120, message= "O tamanho deve ser entre 2 e 120")
	private String nome;
	@NotEmpty(message =  "O campo email não pode ser vazio")
	@Email(message="Email invalido")
	private String email;
	@NotEmpty(message =  "O campo senha não pode ser vazio")
	@Length(min=8, max=30, message= "O tamanho deve ser entre 8 e 30")
	private String senha;
	private Integer perfil;
	private Long academiaId;
	
	public UsuarioNewDTO() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer tipoColaborador) {
		this.perfil = tipoColaborador;
	}

	public Long getAcademiaId() {
		return academiaId;
	}

	public void setAcademiaId(Long academiaId) {
		this.academiaId = academiaId;
	}
	
	

}
