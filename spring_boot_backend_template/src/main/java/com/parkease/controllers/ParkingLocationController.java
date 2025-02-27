package com.parkease.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.parkease.dto.ParkingLocationDto;
import com.parkease.services.ParkingLocationService;

import jakarta.validation.Valid;

@RequestMapping("/location")
@RestController
public class ParkingLocationController {
	
	@Autowired
	private ParkingLocationService parkingLocationService;
	
	private static final String UPLOAD_DIR = "uploads/location_images/";
	
	@PostMapping("/")
	public ResponseEntity<?> insertLocation(@RequestBody @Valid ParkingLocationDto parkingLocationDto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(
				parkingLocationService.insertParkingLocation(parkingLocationDto));
	}
	
	@PutMapping(value="/upload/{id}" ,consumes = {"multipart/form-data"},produces = {"application/json"})
	public ResponseEntity<?> insertLocation(@PathVariable long id, @RequestParam MultipartFile file) throws IOException
	{
		ParkingLocationDto parkingLocationDto=parkingLocationService.findByLocationId(id);
		System.out.println(parkingLocationDto.toString());
		if (file != null && !file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR + fileName);

            Files.createDirectories(filePath.getParent());

            Files.write(filePath, file.getBytes());
            parkingLocationDto.setLocationImagePath(fileName);

            return ResponseEntity.ok(parkingLocationService.updateLocation(parkingLocationDto,id));
        }
        return ResponseEntity.badRequest().body("File is empty or not provided");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getLocation(@PathVariable long id)
	{
		return ResponseEntity.ok(parkingLocationService.findByLocationId(id));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getLocations()
	{
		return ResponseEntity.ok(parkingLocationService.findByLocations());
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateLocation(@RequestBody @Valid ParkingLocationDto parkingLocationDto,@PathVariable long id)
	{
		return ResponseEntity.ok(parkingLocationService.updateLocation(parkingLocationDto,id));
	}
	
	@PutMapping("/status/{id}")
	public ResponseEntity<?> locationStatus(@PathVariable long id)
	{
		return ResponseEntity.ok(parkingLocationService.locationStatus(id));
	}
	
	@GetMapping("/cIty/{city}")
	public ResponseEntity<?> getLocationByCity(@PathVariable String city)
	{
		return ResponseEntity.ok(parkingLocationService.getLocationByCity(city));
	}
}
