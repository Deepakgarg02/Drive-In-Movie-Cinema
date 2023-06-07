package com.MovieCatalog.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieCatalogService.Entity.MovieCatalog;
import com.MovieCatalogService.dao.IMovieCatalogDAO;

@Service
public class MovieCatalogServiceImpl implements IMovieCatalogService{

	@Autowired
	IMovieCatalogDAO movieCatalogDAO;	
	
	@Override
	public MovieCatalog getMovieByTitle(String title) {
		// TODO Auto-generated method stub
		return movieCatalogDAO.getMovieByTitle(title);
	} 

	@Override
	public MovieCatalog updateMovieDetails(String title,MovieCatalog updatedMovie) {
		// TODO Auto-generated method stub
		return movieCatalogDAO.updateMovieDetails(title,updatedMovie);
	}

	@Override
	public String deleteMovieByTitle(String title) {
		// TODO Auto-generated method stub
		return movieCatalogDAO.deleteMovieByTitle(title);
	}

	@Override
	public List<MovieCatalog> getAllMovies() {
		// TODO Auto-generated method stub
		return movieCatalogDAO.getAllMovies();
	}

	@Override
	public MovieCatalog addMovie(MovieCatalog movie) {
		// TODO Auto-generated method stub
		return movieCatalogDAO.addMovie(movie);
	}
	
	

}
