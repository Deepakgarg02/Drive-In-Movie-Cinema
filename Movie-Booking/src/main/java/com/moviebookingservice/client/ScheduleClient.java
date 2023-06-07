package com.moviebookingservice.client;

import java.time.LocalDate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.moviebookingservice.entities.MoviesList;

@FeignClient(name = "MOVIE-SCHEDULE")
public interface ScheduleClient {

	@GetMapping("/schedule/bydate/{date}")
	public MoviesList getMoviesByDate(@PathVariable String date);
}
