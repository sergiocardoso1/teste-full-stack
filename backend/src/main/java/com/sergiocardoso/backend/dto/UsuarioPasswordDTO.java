package com.sergiocardoso.backend.dto;

import javax.validation.constraints.NotEmpty;

public class UsuarioPasswordDTO {
	
	private Long id;
	
	@NotEmpty
	private String novaSenha;
	@NotEmpty
	private String velhaSenha;

	
	public UsuarioPasswordDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getVelhaSenha() {
		return velhaSenha;
	}

	public void setVelhaSenha(String velhaSenha) {
		this.velhaSenha = velhaSenha;
	}


}
