package com.sergiocardoso.backend.dto;

public class ComentarioNewDTO {
	
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
