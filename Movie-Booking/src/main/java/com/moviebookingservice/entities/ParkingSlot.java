package com.moviebookingservice.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "parkingslot")
public class ParkingSlot {

	@Id
	@NotNull
	@Size(min = 1, max = 60)
	private int slotNumber;
	private boolean available;

	public ParkingSlot(@NotNull @Size(min = 2, max = 30) int slotNumber, boolean available) {
		super();
		this.slotNumber = slotNumber;
		this.available = available;
	}

}
