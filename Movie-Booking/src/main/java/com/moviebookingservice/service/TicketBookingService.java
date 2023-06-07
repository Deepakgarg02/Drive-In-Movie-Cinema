package com.moviebookingservice.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.moviebookingservice.entities.MovieTicket;
import com.moviebookingservice.entities.ParkingSlot;
import com.moviebookingservice.exception.ParkingSlotNotFoundException;
import com.moviebookingservice.exception.TicketNotFoundException;

public interface TicketBookingService {

	List<ParkingSlot> getAvailableParkingSlots(String movieTitle,String movieDate)
			throws ParkingSlotNotFoundException;

	MovieTicket bookTicket(String carNumber, String movieTitle, int slotNumber, String date, String time)
			throws ParkingSlotNotFoundException;

	void cancelBooking(String ticketId) throws TicketNotFoundException;

	List<Object> viewBookingDetails(String ticketId) throws TicketNotFoundException;
}
