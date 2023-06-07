package com.MovieCatalogService.dao;

import java.util.List;

import com.MovieCatalogService.Entity.MovieCatalog;

public interface IMovieCatalogDAO {

	
	public MovieCatalog getMovieByTitle(String title);
	//public MovieCatalog updateMovieDetails(String title);
	public String deleteMovieByTitle(String title);
	public List<MovieCatalog> getAllMovies();
	public MovieCatalog addMovie(MovieCatalog movie);
	MovieCatalog updateMovieDetails(String title, MovieCatalog updatedMovie);
}
