package com.parkease.daos;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.parkease.pojos.Reservation;

public interface ReservationDao extends JpaRepository<Reservation,Long>{

	List<Reservation> findByUserUserId(long id);
	
	@Query("SELECT r FROM Reservation r WHERE DATE(r.startTime) = :startOfDay")
    List<Reservation> findByDate(@Param("startOfDay") Timestamp startOfDay);

	List<Reservation> findByStartTimeBetween(Timestamp startTimestamp, Timestamp endTimestamp);
	
	@Query("SELECT r.seat.seatId FROM Reservation r WHERE r.status = 'CONFIRMED' AND r.location.locationId = :locationId")
	 List<Long> findBookedSeatIdsByLocation(@Param("locationId") long locationId);
}

