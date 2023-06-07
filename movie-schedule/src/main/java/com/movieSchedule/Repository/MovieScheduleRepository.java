package com.movieSchedule.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieSchedule.entities.MovieSchedule;

@Repository
public interface MovieScheduleRepository extends JpaRepository<MovieSchedule, Integer>{
	
	MovieSchedule findByMovieTitle(String movieTitle);

}
