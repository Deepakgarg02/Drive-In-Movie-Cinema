package com.moviebookingservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.moviebookingservice.entities.MovieCatalog;

@FeignClient(name = "MOVIE-CATALOG")
public interface CatalogService {
	
	@GetMapping("/movie/{title}")
	public MovieCatalog getMovieByTitle(@PathVariable String title) ;

}
