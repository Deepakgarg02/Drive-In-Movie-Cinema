package com.MovieCatalogService.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MovieCatalog.Service.IMovieCatalogService;
import com.MovieCatalogService.Entity.MovieCatalog;
import com.MovieCatalogService.Exception.MovieNotFoundException;
import com.MovieCatalogService.Repositories.MovieCatalogRepo;

@RestController
@RequestMapping("/movie")
public class MovieCatalogController {


	@Autowired
	private IMovieCatalogService imovieCatalogService;
	
	@GetMapping("/{title}")
	public MovieCatalog getMovieByTitle(@PathVariable String title) {
		return imovieCatalogService.getMovieByTitle(title);
	}
	

	@PutMapping("/{title}")
	public MovieCatalog updateMovieDetails(@PathVariable String title,@RequestBody MovieCatalog updatedMovie) {
		return imovieCatalogService.updateMovieDetails(title, updatedMovie);
			
	}

	
	@DeleteMapping("/{title}")
	public String deleteMovieByTitle(@PathVariable String title) {
		
		return imovieCatalogService.deleteMovieByTitle(title);
	}

	@GetMapping
	public List<MovieCatalog> getAllMovies() {
		
		return imovieCatalogService.getAllMovies();
	}

	@PostMapping
	public MovieCatalog addMovie(@RequestBody MovieCatalog movie) {

		return imovieCatalogService.addMovie(movie);
	}

}
