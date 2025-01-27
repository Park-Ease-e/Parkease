package com.parkease.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkease.pojos.Seat;

public interface SeatDao extends JpaRepository<Seat,Long>{

}
