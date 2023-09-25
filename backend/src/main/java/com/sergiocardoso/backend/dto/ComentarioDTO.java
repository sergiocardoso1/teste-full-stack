package com.sergiocardoso.backend.dto;

public class ComentarioDTO {
	
	private Long id;
	private String comentario;
	private Long cervejaId;
	
	public ComentarioDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
