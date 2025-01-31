package com.parkease.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.parkease.pojos.Seat;

public interface SeatDao extends JpaRepository<Seat,Long>{
	 
}
