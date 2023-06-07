package com.moviebookingservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingservice.entities.MovieTicket;

@Repository
public interface MovieTicketRepository extends MongoRepository<MovieTicket, String> {

	MovieTicket findByMovieTitle(String movieTitle);

}
