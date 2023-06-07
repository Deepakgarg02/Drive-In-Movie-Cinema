package com.movieSchedule.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieSchedule.Exception.ResourceNotFoundException;
import com.movieSchedule.dao.IMovieScheduleDAO;
import com.movieSchedule.entities.MovieSchedule;

@Service
public class MovieScheduleServiceImpl implements IMovieScheduleService {
	
	@Autowired
	IMovieScheduleDAO movieScheduleDao;
	
	public MovieSchedule addSchedule(MovieSchedule movieSchedule) {
		return movieScheduleDao.addSchedule(movieSchedule);
	}
	public List<MovieSchedule> getAllSchedule(){
		return movieScheduleDao.getAllSchedule();
	}
	public MovieSchedule getSchedule(String movieTitle) {
		return movieScheduleDao.getSchedule(movieTitle);
	}
	public void deleteSchedule(String movieTitle) {
		 movieScheduleDao.deleteSchedule(movieTitle);
	}
	public MovieSchedule updateSchedule(String movieTitle,MovieSchedule updatedMovie) throws ResourceNotFoundException{
		return movieScheduleDao.updateSchedule(movieTitle, updatedMovie);
	};

}
