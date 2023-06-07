package com.moviebookingservice.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.moviebookingservice.entities.MovieTicket;
import com.moviebookingservice.entities.ParkingSlot;
import com.moviebookingservice.exception.ParkingSlotNotFoundException;
import com.moviebookingservice.exception.TicketNotFoundException;
import com.moviebookingservice.service.TicketBookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private TicketBookingService ticketBookingService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/ViewSlot/{movieTitle}/{movieDate}")
	public List<ParkingSlot> bookMovie(@PathVariable String movieTitle, @PathVariable String movieDate)
			throws ParkingSlotNotFoundException {
		return ticketBookingService.getAvailableParkingSlots(movieTitle, movieDate);
	}

//	@GetMapping("/view")
//	public MovieSchedule all(@RequestParam String movieTitle) {
// 		MovieSchedule movies =  restTemplate
//				.getForObject("http://localhost:8082/schedule/byTitle/" + movieTitle, MovieSchedule.class);
//		return movies;
//	}
	
//	@GetMapping("/view/{movieDate1}")
//	public MoviesList all(@PathVariable String movieDate1) {
//		 LocalDate movieDate = LocalDate.parse(movieDate1);
// 		MoviesList movies =  restTemplate
//				.getForObject("http://localhost:8082/schedule/bydate/" + movieDate, MoviesList.class);
//		return movies;
//	}

	@PostMapping("/book")
	public MovieTicket bookTicket(@RequestParam String carNumber, @RequestParam String movieTitle,
			@RequestParam int slotNumber, @RequestParam String date, @RequestParam String time)
			throws ParkingSlotNotFoundException {
		return ticketBookingService.bookTicket(carNumber, movieTitle, slotNumber, date, time);

	}

	@DeleteMapping("cancelBooking/{ticketId}")
	public String cancelTicket(@PathVariable String ticketId) throws TicketNotFoundException {
		ticketBookingService.cancelBooking(ticketId);
		return "Ticket Cancelled";
	}

	@GetMapping("/viewBooking/{ticketId}")
	public List<Object> getTicketDetails(@PathVariable String ticketId) throws TicketNotFoundException {
		return ticketBookingService.viewBookingDetails(ticketId);
	}
}
