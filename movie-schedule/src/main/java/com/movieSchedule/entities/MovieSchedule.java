package com.movieSchedule.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MovieSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int id;
	private String movieTitle;
	private LocalTime showTime;
	private LocalDate date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDate getDate() {
		return date;
	}
	
	public LocalTime getShowTime() {
		return showTime;
	}
	public MovieSchedule(int id, String movieTitle, LocalTime showTime, LocalDate date) {
		super();
		this.id = id;
		this.movieTitle = movieTitle;
		this.showTime = showTime;
		this.date = date;
	}
	
	public MovieSchedule() {
		super();
		
	}

	
	
	
}
