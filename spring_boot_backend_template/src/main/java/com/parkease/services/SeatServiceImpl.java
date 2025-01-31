package com.parkease.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkease.customexception.ResourceNotFoundException;
import com.parkease.daos.ParkingLocationDao;
import com.parkease.daos.ReservationDao;
import com.parkease.pojos.ParkingLocation;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SeatServiceImpl implements SeatService{
	@Autowired
	private ReservationDao reservationDao;
	
	@Autowired
	private ParkingLocationDao parkingLocationDao; 

	@Override
	public List<Long> getBookedSeats(long id) {
        ParkingLocation location=parkingLocationDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("Location not found"));
        return reservationDao.findBookedSeatIdsByLocation(id);		
	}
}
