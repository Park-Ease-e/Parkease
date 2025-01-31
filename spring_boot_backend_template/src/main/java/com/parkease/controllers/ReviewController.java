package com.parkease.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkease.dto.ReviewDto;
import com.parkease.services.ReviewService;

@RequestMapping("/review")
@RestController
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping("/")
	public ResponseEntity<?> insertReview(@RequestBody ReviewDto reviewDto)
	{
		return ResponseEntity.ok(reviewService.insertReview(reviewDto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getReviews(@PathVariable long id)
	{
		return ResponseEntity.ok(reviewService.getReviews(id));
	}
}
