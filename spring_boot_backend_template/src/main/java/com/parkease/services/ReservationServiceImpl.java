package com.parkease.services;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkease.customexception.ResourceNotFoundException;
import com.parkease.daos.ParkingLocationDao;
import com.parkease.daos.ReservationDao;
import com.parkease.daos.SeatDao;
import com.parkease.daos.TransactionDao;
import com.parkease.daos.UserDao;
import com.parkease.daos.VehicleDao;
import com.parkease.dto.ApiResponse;
import com.parkease.dto.ReservationDto;
import com.parkease.dto.ReservationTransactionVehicleWrapperDto;
import com.parkease.dto.TransactionDto;
import com.parkease.dto.VehicleDto;
import com.parkease.eums.ReservationStatus;
import com.parkease.pojos.ParkingLocation;
import com.parkease.pojos.Reservation;
import com.parkease.pojos.Seat;
import com.parkease.pojos.Transaction;
import com.parkease.pojos.User;
import com.parkease.pojos.Vehicle;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{
	@Autowired 
	private TransactionDao transactionDao;
	
	@Autowired 
	private ReservationDao reservationDao;
	
	@Autowired 
	private VehicleDao vehicleDao;
	
	@Autowired
	private ParkingLocationDao parkingLocationDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SeatDao seatDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmailService emailService;

	@Override
	public ApiResponse insertReservation(ReservationTransactionVehicleWrapperDto dto) {
		VehicleDto vehicleDto=dto.getVehicleDto();
		ReservationDto reservationDto=dto.getReservationDto();
		TransactionDto transactionDto=dto.getTrasactionDto();
		//---------------------------------------------------------
		LocalDateTime localDateTime = reservationDto.getStartTime().toLocalDateTime();
        localDateTime = localDateTime.minusHours(5).minusMinutes(30);
        reservationDto.setStartTime(Timestamp.valueOf(localDateTime));
        localDateTime = reservationDto.getEndTime().toLocalDateTime();
        localDateTime = localDateTime.minusHours(5).minusMinutes(30);
        reservationDto.setEndTime(Timestamp.valueOf(localDateTime));
        
        //----------------------------------------------------------
        
        log.info(" " + reservationDto.getStartTime());
		log.info(" " + reservationDto.getEndTime());
		
		Vehicle vehicle = vehicleDao.save(modelMapper.map(vehicleDto, Vehicle.class));
		Transaction transaction=modelMapper.map(transactionDto, Transaction.class);
		User user=userDao.findById(transactionDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		user.addTransaction(transaction);
		transaction=transactionDao.save(transaction);
		Reservation reservation=modelMapper.map(reservationDto, Reservation.class);
		reservation.setVehicle(vehicle);
		reservation.setTransaction(transaction);
		user.addReservation(reservation);
		Seat seat=seatDao.findById(reservationDto.getSeatId()).orElseThrow(() -> new ResourceNotFoundException("Seat not found"));
		seat.addReservations(reservation);
		ParkingLocation location=parkingLocationDao.findById(reservationDto.getLocationId()).orElseThrow(() -> new ResourceNotFoundException("Location not found"));
		location.addReservation(reservation);
		reservationDao.save(reservation);
		emailService.sendReservationDtails(reservation);
		return new ApiResponse("Booking Successfull");
	}

	@Override
	public List<ReservationDto> getReservations() {
		List<Reservation> reservations=reservationDao.findAll();
		List<ReservationDto> reservationDtos=new ArrayList<>();
		for(Reservation reservation:reservations)
		{
			ReservationDto reservationDto=modelMapper.map(reservation, ReservationDto.class);
			reservationDto.setUserId(reservation.getUser().getUserId());
			reservationDto.setLocationId(reservation.getLocation().getLocationId());
			reservationDto.setSeatId(reservation.getSeat().getSeatId());
			reservationDto.setVehicleId(reservation.getUser().getUserId());
			reservationDto.setTransactionId(reservation.getTransaction().getTransactionId());
			reservationDtos.add(reservationDto);		
		}
		return reservationDtos;
	}

	@Override
	public List<ReservationDto> getUserReservations(long id) {
		User user=userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		List<Reservation> reservations=reservationDao.findByUserUserId(id);
		List<ReservationDto> reservationDtos=new ArrayList<>();
		for(Reservation reservation:reservations)
		{
			ReservationDto reservationDto=modelMapper.map(reservation, ReservationDto.class);
			reservationDto.setUserId(reservation.getUser().getUserId());
			reservationDto.setLocationId(reservation.getLocation().getLocationId());
			reservationDto.setSeatId(reservation.getSeat().getSeatId());
			reservationDto.setVehicleId(reservation.getVehicle().getVehicleId());
			reservationDto.setTransactionId(reservation.getTransaction().getTransactionId());
			reservationDtos.add(reservationDto);		
		}
		return reservationDtos;
	}

	@Override
	public List<ReservationDto> getReservationsByDate(LocalDate date) {
		 LocalDateTime startOfDay = date.atStartOfDay();
         Timestamp startTimestamp = Timestamp.valueOf(startOfDay);
		List<Reservation> reservations=reservationDao.findByDate(startTimestamp);
		List<ReservationDto> reservationDtos=new ArrayList<>();
		for(Reservation reservation:reservations)
		{
			ReservationDto reservationDto=modelMapper.map(reservation, ReservationDto.class);
			reservationDto.setUserId(reservation.getUser().getUserId());
			reservationDto.setLocationId(reservation.getLocation().getLocationId());
			reservationDto.setSeatId(reservation.getSeat().getSeatId());
			reservationDto.setVehicleId(reservation.getUser().getUserId());
			reservationDto.setTransactionId(reservation.getTransaction().getTransactionId());
			reservationDtos.add(reservationDto);		
		}
		return reservationDtos;
	}

	@Override
	public ApiResponse cancelReservation(long uid, long rid) {
		User user=userDao.findById(uid).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		Reservation reservation=reservationDao.findById(rid).orElseThrow(() -> new ResourceNotFoundException("Reservation not found"));
		reservation.setStatus(ReservationStatus.CANCELLED);
		reservationDao.save(reservation);
		return new ApiResponse("Reservation Cancelled");
	}
	
}
