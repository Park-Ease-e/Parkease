package com.parkease.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkease.pojos.Review;

public interface ReviewDao extends JpaRepository<Review,Long>{

}
