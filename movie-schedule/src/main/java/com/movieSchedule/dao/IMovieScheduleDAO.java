package com.movieSchedule.dao;

import java.util.List;

import com.movieSchedule.Exception.ResourceNotFoundException;
import com.movieSchedule.entities.MovieSchedule;

public interface IMovieScheduleDAO {

	public MovieSchedule addSchedule(MovieSchedule movieSchedule);
	public List<MovieSchedule> getAllSchedule();
	public MovieSchedule getSchedule(String movieTitle);
	public void deleteSchedule(String movieTitle);
	public MovieSchedule updateSchedule(String movieTitle,MovieSchedule updatedMovie) throws ResourceNotFoundException;
}
