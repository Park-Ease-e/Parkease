package com.parkease.services;

import java.util.List;

import com.parkease.dto.ApiResponse;
import com.parkease.dto.ParkingLocationDto;

public interface ParkingLocationService {

	ApiResponse insertParkingLocation(ParkingLocationDto parkingLocationDto);

	ApiResponse updateLocation(ParkingLocationDto parkingLocationDto, long id);

	ParkingLocationDto findByLocationId(long id);

	List<ParkingLocationDto> findByLocations();

	ApiResponse locationStatus(long id);

	List<ParkingLocationDto> getLocationByCity(String city);

}
