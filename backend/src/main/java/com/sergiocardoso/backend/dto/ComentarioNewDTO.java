package com.sergiocardoso.backend.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ComentarioNewDTO {
	
	@NotEmpty(message = "O campo nome não pode ser vazio")
	@Length(min = 3, max = 120, message = "O tamanho deve ser entre 3 e 120")
	private String comentario;
	private Long cervejaId;
	
	public ComentarioNewDTO() {
		
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Long getCervejaId() {
		return cervejaId;
	}

	public void setCervejaId(Long cervejaId) {
		this.cervejaId = cervejaId;
	}
	
	

}
