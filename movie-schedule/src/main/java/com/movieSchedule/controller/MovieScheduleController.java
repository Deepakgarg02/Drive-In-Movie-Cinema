package com.movieSchedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieSchedule.Exception.ResourceNotFoundException;
import com.movieSchedule.Service.IMovieScheduleService;
import com.movieSchedule.entities.MovieSchedule;

@RestController
@RequestMapping("/shows")
public class MovieScheduleController {
	
	@Autowired
	private IMovieScheduleService imovieScheduleService;
	
	@PostMapping("/addSchedule")
	public MovieSchedule addSchedule(MovieSchedule movieSchedule) {
		return imovieScheduleService.addSchedule(movieSchedule);
	};
	
	@GetMapping("/")
	public List<MovieSchedule> getAllSchedule(){
		return imovieScheduleService.getAllSchedule();
	};
	
	@GetMapping("get/{movieTitle}")
	public MovieSchedule getSchedule(@PathVariable String movieTitle) {
		return imovieScheduleService.getSchedule(movieTitle);
	};
	
	@DeleteMapping("/deleteSchedule")
	public void deleteSchedule(String movieTitle) {
		 imovieScheduleService.deleteSchedule(movieTitle);
	};
	
	@PutMapping("update/{movieTitle}")
	public MovieSchedule updateSchedule(@PathVariable String movieTitle,MovieSchedule updatedMovie) throws ResourceNotFoundException{
		return imovieScheduleService.updateSchedule(movieTitle, updatedMovie);
	};
	
	
	
	

}
