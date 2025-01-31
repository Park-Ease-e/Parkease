package com.parkease.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.parkease.eums.ReservationStatus;
import com.parkease.eums.Role;
import com.parkease.pojos.ParkingLocation;
import com.parkease.pojos.Seat;
import com.parkease.pojos.Session;
import com.parkease.pojos.Transaction;
import com.parkease.pojos.User;
import com.parkease.pojos.Vehicle;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
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
public class ReservationDto {
	@JsonProperty(access = Access.READ_ONLY)
	private long reservationId;
	
	private long userId;
	
	private long locationId;
	
	private long seatId;
	
	private long vehicleId;
	
	private long transactionId;
	
	@NotNull(message = "Start is required")
    private Timestamp startTime;
    
    @NotNull(message = "End time is required")
    private Timestamp endTime;

    private ReservationStatus status;

}
