package com.MovieCatalog.Service;

import java.util.List;

import com.MovieCatalogService.Entity.MovieCatalog;

public interface IMovieCatalogService {
	
	public MovieCatalog getMovieByTitle(String title);
//	public MovieCatalog updateMovieDetails(String title);
	public String deleteMovieByTitle(String title);
	public List<MovieCatalog> getAllMovies();
	public MovieCatalog addMovie(MovieCatalog movie);
	MovieCatalog updateMovieDetails(String title, MovieCatalog updatedMovie);
}
