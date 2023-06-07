package com.moviebookingservice.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieSchedule {

	private int id;
	private String movieTitle;
	private LocalTime showTime;
	private LocalDate date;

}
