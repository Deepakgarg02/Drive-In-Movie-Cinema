package com.MovieCatalogService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieCatalogService.Entity.MovieCatalog;

@Repository
public interface MovieCatalogRepo extends JpaRepository<MovieCatalog, String> {

	// custom finder methods
	MovieCatalog findByTitle(String title);

}
