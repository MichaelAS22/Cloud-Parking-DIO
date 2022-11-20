package one.digitalinnovation.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.model.Parking;
import one.digitalinnovation.service.ParkingService;

@RestController
@RequestMapping("/parking")
public class ParkingController {
	
	private final ParkingService parkingService;
	
	public ParkingController(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	@GetMapping
	public List<Parking> findAll(){
		return parkingService.findAll();
	}
}
