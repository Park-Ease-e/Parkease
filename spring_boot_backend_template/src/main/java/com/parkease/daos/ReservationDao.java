package com.parkease.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkease.pojos.Reservation;

public interface ReservationDao extends JpaRepository<Reservation,Long>{

}
