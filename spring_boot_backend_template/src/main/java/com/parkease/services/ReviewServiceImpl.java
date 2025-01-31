package com.parkease.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkease.customexception.ResourceNotFoundException;
import com.parkease.daos.ParkingLocationDao;
import com.parkease.daos.ReviewDao;
import com.parkease.daos.UserDao;
import com.parkease.dto.ApiResponse;
import com.parkease.dto.ReviewDto;
import com.parkease.pojos.ParkingLocation;
import com.parkease.pojos.Review;
import com.parkease.pojos.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ParkingLocationDao parkingLocationDao;
	
	@Override
	public ApiResponse insertReview(ReviewDto reviewDto) {
		User user=userDao.findById(reviewDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		ParkingLocation location=parkingLocationDao.findById(reviewDto.getLocationId()).orElseThrow(() -> new ResourceNotFoundException("Location not found"));
		Review review = modelMapper.map(reviewDto, Review.class);
		user.addReviews(review);
		location.addReviews(review);
		return new ApiResponse("Thanks for your review");
	}

	@Override
	public List<ReviewDto> getReviews(long id) {
		List<Review> reviews=reviewDao.findByLocationLocationId(id);
		List<ReviewDto> reviewDtos=new ArrayList<>();
		for(Review review : reviews)
		{
			ReviewDto reviewDto=modelMapper.map(review, ReviewDto.class);
			reviewDto.setLocationId(review.getLocation().getLocationId());
			reviewDto.setUserId(review.getUser().getUserId());
			reviewDtos.add(reviewDto);
		}
		return reviewDtos;
	}
	
}
