package com.parkease.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkease.pojos.Vehicle;

public interface VehicleDao extends JpaRepository<Vehicle,Long>{

}
