package com.moviebookingservice.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "movieTicket")
public class MovieTicket {

	@Id
	private String id;
	private String carNumber;
	private String movieTitle;
	private int slotNumber;
	private double price;
	private String status;
	private LocalDate date;
	private LocalTime time;

	public MovieTicket(String carNumber, String movieTitle, int slotNumber, String status, LocalDate date,
			LocalTime time) {
		super();
		this.carNumber = carNumber;
		this.movieTitle = movieTitle;
		this.slotNumber = slotNumber;
		this.status = status;
		this.date = date;
		this.time = time;
		calculatePrice();
	}

	public void calculatePrice() {

		double price = 0;
		if (slotNumber >= 1 && slotNumber <= 20) {
			price = 1000;
		} else if (slotNumber >= 21 && slotNumber <= 40) {
			price = 700;
		} else {
			price = 300;
		}
		this.price = price;
	}

}
