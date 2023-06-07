package com.moviebookingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviebookingservice.entities.ParkingSlot;
import com.moviebookingservice.exception.ParkingSlotNotFoundException;
import com.moviebookingservice.repository.ParkingSlotRepository;
import com.moviebookingservice.service.ParkingSlotService;

@RestController
@RequestMapping("/slot")
public class SlotController {

	@Autowired
	private ParkingSlotRepository parkingSlotRepository;

	@Autowired
	private ParkingSlotService parkingSlotService;

	@GetMapping("/view/{slotNumber}")
	public ParkingSlot viewParkingSlot(@PathVariable int slotNumber) throws ParkingSlotNotFoundException {
		return parkingSlotService.getParkingSlotBySlotNumber(slotNumber);

	}

	@PostMapping("/add")
	public void addParkingSlot(@RequestBody ParkingSlot parkingSlot) {
		parkingSlotService.addParkingSlot(parkingSlot);

	}

	@GetMapping("/viewAll")
	public List<ParkingSlot> viewAllParking() {

		return parkingSlotService.viewAllParkingSlotId();
	}

	@GetMapping("/add-all")
	public List<ParkingSlot> addParkingSlotByLoop() {
		for (int i = 1; i < 61; i++) {
			parkingSlotRepository.save(new ParkingSlot(i, true));
		}

		return parkingSlotRepository.findAll();

	}

	@PutMapping("/update/{slotNumber}/{result}")
	public ParkingSlot updateParkingSlot(@PathVariable int slotNumber,@PathVariable boolean result)
			throws ParkingSlotNotFoundException {
		return parkingSlotService.updateParkingSlot(slotNumber, result);
	}

	@DeleteMapping("/delete/{slotNumber}")
	public ParkingSlot deleteParking(@PathVariable int slotNumber) throws ParkingSlotNotFoundException {

		return parkingSlotService.deleteParkingSlot(slotNumber);

	}

}
