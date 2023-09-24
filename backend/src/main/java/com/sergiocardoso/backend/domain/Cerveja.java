package com.sergiocardoso.backend.domain;

import java.util.Objects;

public class Cerveja {

	private Long id;
	private String name;
	private String tagline;
	private Double abv;
	private String image_url;

	public Cerveja() {

	}

	public Cerveja(Long id, String name, String tagline, Double abv, String image_url) {
		super();
		this.id = id;
		this.name = name;
		this.tagline = tagline;
		this.abv = abv;
		this.image_url = image_url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public Double getAbv() {
		return abv;
	}

	public void setAbv(Double abv) {
		this.abv = abv;
	}
	

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerveja other = (Cerveja) obj;
		return Objects.equals(id, other.id);
	}

}
