package com.MovieCatalogService.Entity;

import jakarta.persistence.*;

@Entity
public class MovieCatalog {

	@Id
	
	private String id;
	private String title;
	private String description;
	private String genre;
	private double imdbRating;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public MovieCatalog(String id, String title, String description, String genre, double imdbRating) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.imdbRating = imdbRating;
	}

	public MovieCatalog() {
		super();
	}

}


