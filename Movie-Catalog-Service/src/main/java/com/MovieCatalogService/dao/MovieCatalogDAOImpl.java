package com.MovieCatalogService.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.MovieCatalogService.Entity.MovieCatalog;
import com.MovieCatalogService.Exception.MovieNotFoundException;
import com.MovieCatalogService.Repositories.MovieCatalogRepo;

@Component
public class MovieCatalogDAOImpl implements IMovieCatalogDAO {
	
	@Autowired
	private MovieCatalogRepo movieCatalogRepo;
	
	public MovieCatalog getMovieByTitle(String title) {
		MovieCatalog movie = movieCatalogRepo.findByTitle(title);
		return movie;
	}

	@Override
	public MovieCatalog updateMovieDetails(String title, MovieCatalog updatedMovie) {
		// TODO Auto-generated method stub
		MovieCatalog movie = movieCatalogRepo.findByTitle(title);
		if (movie == null) {
			throw new MovieNotFoundException("Movie not found for title: " + title);
		}
		movie.setTitle(updatedMovie.getTitle());
		movie.setDescription(updatedMovie.getDescription());
		movie.setGenre(updatedMovie.getGenre());
		movie.setImdbRating(updatedMovie.getImdbRating());
		MovieCatalog savedMovie = movieCatalogRepo.save(movie);
		return movie;
	}

	@Override
	public String deleteMovieByTitle(String title) {
		// TODO Auto-generated method stub
		MovieCatalog movie = movieCatalogRepo.findByTitle(title);
		if (movie == null) {
			throw new MovieNotFoundException("Movie not found for title: " + title);
		}
		movieCatalogRepo.delete(movie);
		return null;
		
	}

	@Override
	public List<MovieCatalog> getAllMovies() {
		// TODO Auto-generated method stub
		List<MovieCatalog> movies = movieCatalogRepo.findAll();
		if (movies.isEmpty()) {
			throw new MovieNotFoundException("No movies found");
		}
		return movies;
	}

	@Override
	public MovieCatalog addMovie(MovieCatalog movie) {
		// TODO Auto-generated method stub
		return movieCatalogRepo.save(movie);
	}
	
	
}
