package com.parkease.services;

import java.util.List;

import com.parkease.dto.ApiResponse;
import com.parkease.dto.ReviewDto;
import com.parkease.pojos.Review;

public interface ReviewService {

	ApiResponse insertReview(ReviewDto reviewDto);

	List<ReviewDto> getReviews(long id);

}
