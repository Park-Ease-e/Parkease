package com.parkease.services;

import java.time.LocalDate;
import java.util.List;

import com.parkease.dto.ApiResponse;
import com.parkease.dto.ReservationDto;
import com.parkease.dto.ReservationTransactionVehicleWrapperDto;

public interface ReservationService {

	ApiResponse insertReservation(ReservationTransactionVehicleWrapperDto dto);

	List<ReservationDto> getReservations();

	List<ReservationDto> getUserReservations(long id);

	List<ReservationDto> getReservationsByDate(LocalDate date);

	ApiResponse cancelReservation(long uid, long rid);

}
