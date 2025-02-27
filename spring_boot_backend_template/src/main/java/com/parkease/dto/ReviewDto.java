package com.parkease.dto;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.parkease.pojos.ParkingLocation;
import com.parkease.pojos.Reservation;
import com.parkease.pojos.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
	@JsonProperty(access = Access.READ_ONLY)
	private long reviewId;
	
	private long userId;
	
	private long locationId;
	
	private Integer rating;
	
    private String reviewText;
}
