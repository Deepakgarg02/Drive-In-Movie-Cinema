package com.movieSchedule.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movieSchedule.Exception.ResourceNotFoundException;
import com.movieSchedule.Repository.MovieScheduleRepository;
import com.movieSchedule.entities.MovieSchedule;

@Component
public class MovieScheduleDAOImpl implements IMovieScheduleDAO{
	
	@Autowired
	MovieScheduleRepository movieScheduleRepository;
	
	public MovieSchedule addSchedule(MovieSchedule movieSchedule) {
		return movieScheduleRepository.save(movieSchedule);
	}
	
	public List<MovieSchedule> getAllSchedule(){
		return movieScheduleRepository.findAll();
	}
	
	public MovieSchedule getSchedule(String movieTitle) {
		return movieScheduleRepository.findByMovieTitle(movieTitle);
	}
	
	public void deleteSchedule(String movieTitle) {
		MovieSchedule movieSchedule = movieScheduleRepository.findByMovieTitle(movieTitle);
		movieScheduleRepository.delete(movieSchedule);
	}
	
	public MovieSchedule updateSchedule(String movieTitle,MovieSchedule updatedMovie) throws ResourceNotFoundException {
		MovieSchedule movieSchedule = movieScheduleRepository.findByMovieTitle(movieTitle);
		if (movieSchedule == null) {
			throw new ResourceNotFoundException("Resource not found");
		}
		movieSchedule.setMovieTitle(updatedMovie.getMovieTitle());
		movieSchedule.setDate(updatedMovie.getDate());
		movieSchedule.setShowTime(updatedMovie.getShowTime());
		MovieSchedule savedSchedule = movieScheduleRepository.save(movieSchedule);
		return movieSchedule;
		
	}
}
