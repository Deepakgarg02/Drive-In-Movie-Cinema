package com.moviebookingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebookingservice.entities.ParkingSlot;
import com.moviebookingservice.exception.ParkingSlotNotFoundException;
import com.moviebookingservice.repository.ParkingSlotRepository;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

	@Autowired
	private ParkingSlotRepository parkingSlotRepository;

	@Override
	public ParkingSlot getParkingSlotBySlotNumber(int slotNumber) throws ParkingSlotNotFoundException {
		// TODO Auto-generated method stub
		return parkingSlotRepository.findBySlotNumber(slotNumber)
				.orElseThrow(() -> new ParkingSlotNotFoundException("Parking Not Available"));
	}

	@Override
	public List<ParkingSlot> viewAllParkingSlotId() {
		// TODO Auto-generated method stub
		return parkingSlotRepository.findAll();
	}

	@Override
	public ParkingSlot deleteParkingSlot(int slotNumber) throws ParkingSlotNotFoundException {
		// TODO Auto-generated method stub
		ParkingSlot parkingSlot = getParkingSlotBySlotNumber(slotNumber);
		parkingSlotRepository.delete(parkingSlot);
		return parkingSlot;
	}

	@Override
	public void addParkingSlot(ParkingSlot parkingSlot) {
		// TODO Auto-generated method stub
		parkingSlotRepository.save(parkingSlot);

	}

	@Override
	public ParkingSlot updateParkingSlot(int slotNumber,boolean result) throws ParkingSlotNotFoundException {
		ParkingSlot parking = getParkingSlotBySlotNumber(slotNumber);
		// parking.setSeatType(seatType);
		parking.setAvailable(result);
		parkingSlotRepository.save(parking);
		return parking;
	}

}
