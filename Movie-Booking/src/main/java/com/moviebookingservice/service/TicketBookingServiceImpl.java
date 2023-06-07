package com.moviebookingservice.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moviebookingservice.client.CatalogService;
import com.moviebookingservice.client.ScheduleClient;
import com.moviebookingservice.entities.MovieCatalog;
import com.moviebookingservice.entities.MovieSchedule;
import com.moviebookingservice.entities.MovieTicket;
import com.moviebookingservice.entities.MoviesList;
import com.moviebookingservice.entities.ParkingSlot;
import com.moviebookingservice.exception.ParkingSlotNotFoundException;
import com.moviebookingservice.exception.TicketNotFoundException;
import com.moviebookingservice.repository.MovieTicketRepository;
import com.moviebookingservice.repository.ParkingSlotRepository;

@Service
public class TicketBookingServiceImpl implements TicketBookingService {

	@Autowired
	private MovieTicketRepository movieTicketRepository;

	@Autowired
	private ParkingSlotRepository parkingSlotRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CatalogService catalogService;

	@Autowired
	private ScheduleClient scheduleClient;

	@Override
	public List<ParkingSlot> getAvailableParkingSlots(String movieTitle, String movieDate)
			throws ParkingSlotNotFoundException {

		//by RestTemplate
 		//MoviesList moviesList = restTemplate.getForObject("http://localhost:8082/schedule/bydate/" + movieDate, MoviesList.class);
		
		//ByFeignClient
		MoviesList moviesList = scheduleClient.getMoviesByDate(movieDate);
		List<MovieSchedule> movies = moviesList.getAllMovies();

		List<String> movieTitles = new ArrayList<>();

		for (MovieSchedule movie : movies) {
			movieTitles.add(movie.getMovieTitle());
		}

		if (movieTitles.contains(movieTitle)) {
			List<ParkingSlot> availableSlot = parkingSlotRepository.findByAvailable(true);
			return availableSlot;
		} else {
			throw new ParkingSlotNotFoundException(movieTitle + "Not Available");
		}

	}

	@Override
	public MovieTicket bookTicket(String carNumber, String movieTitle, int slotNumber, String date, String time)
			throws ParkingSlotNotFoundException {
		// TODO Auto-generated method stub
		MovieTicket ticket = null;
		LocalDate date1 = LocalDate.parse(date);
		LocalTime time1 = LocalTime.parse(time);

		ParkingSlot parkingSlot = parkingSlotRepository.findBySlotNumber(slotNumber)
				.orElseThrow(() -> new ParkingSlotNotFoundException("Slot Number " + slotNumber + " not found"));

		if (parkingSlot != null && parkingSlot.isAvailable()) {
			parkingSlot.setAvailable(false);
			ticket = new MovieTicket(carNumber, movieTitle, slotNumber, "Booked", date1, time1);
			parkingSlotRepository.save(parkingSlot);
			movieTicketRepository.save(ticket);
		} else {
			throw new ParkingSlotNotFoundException("Slot " + slotNumber + " is not Available");
		}
		return ticket;
	}

	@Override
	public void cancelBooking(String ticketId) throws TicketNotFoundException {
		// TODO Auto-generated method stub

		MovieTicket ticket = movieTicketRepository.findById(ticketId)
				.orElseThrow(() -> new TicketNotFoundException("Ticket " + ticketId + " not Available"));
		ticket.setStatus("Cancelled");
		int slotNumber = ticket.getSlotNumber();
		Optional<ParkingSlot> parkingSlot = parkingSlotRepository.findBySlotNumber(slotNumber);
		if (parkingSlot.isPresent()) {
			parkingSlot.get().setAvailable(true);
		}
		parkingSlotRepository.save(parkingSlot.get());
		movieTicketRepository.save(ticket);
	}

	@Override
	public List<Object> viewBookingDetails(String ticketId) throws TicketNotFoundException {
		List<Object> list = new ArrayList<>();
		MovieTicket ticket = movieTicketRepository.findById(ticketId)
				.orElseThrow(() -> new TicketNotFoundException("Ticket" + ticketId + " not found"));

		MovieCatalog movieCatalogue = catalogService.getMovieByTitle(ticket.getMovieTitle());

		list.add(ticket);
		list.add(movieCatalogue);
		return list;
	}

}
