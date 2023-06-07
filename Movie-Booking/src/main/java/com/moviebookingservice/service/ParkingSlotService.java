package com.moviebookingservice.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.moviebookingservice.entities.ParkingSlot;
import com.moviebookingservice.exception.ParkingSlotNotFoundException;

public interface ParkingSlotService {

	public ParkingSlot getParkingSlotBySlotNumber(int slotNumber) throws ParkingSlotNotFoundException;

	public List<ParkingSlot> viewAllParkingSlotId();

	public ParkingSlot deleteParkingSlot(int slotNumber) throws ParkingSlotNotFoundException;

	public void addParkingSlot(ParkingSlot parkingSlot);

	public ParkingSlot updateParkingSlot(int slotNumber, boolean result) throws ParkingSlotNotFoundException;
}
