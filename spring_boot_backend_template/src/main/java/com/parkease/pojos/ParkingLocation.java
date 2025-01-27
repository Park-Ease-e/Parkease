package com.parkease.pojos;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="parking_locations")
public class ParkingLocation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="location_id")
	private long locationId;
	
	@NotBlank(message = "Location name is required")
    @Column(name="location_name")
	private String locationName;
	
	@NotBlank(message = "Address is required")
	private String address;
	
	@NotNull(message = "Hourly rate is required")
	private double longitude;
	
	@NotNull(message = "Hourly rate is required")
    private double latitude;
    
    @NotNull(message = "Hourly rate is required")
    @Column(name="hourly_rate")
    private BigDecimal hourlyRate;
    
    @NotNull(message = "Total seats is required")
    @Column(name="total_seats")
    private Integer totalSeats;
    
    @Column(name = "`rows`")
    private Integer rows;
    
    @Column(name = "`colums`")
    private Integer columns;
    
    @NotNull(message = "Opening time is required")
    @Column(name="opening_time")
    private LocalTime openingTime;
    
    @NotNull(message = "Closing time is required")
    @Column(name="closing_time")
    private LocalTime closingTime;
    
    @Column(name="is_active")
    private Boolean isActive;
    
    private String contact;
    
    private Boolean cctv;
    
    private Boolean valetParking;
    
    @Column(name = "location_image", length = 500)
    private String locationImagePath;

    @CreationTimestamp
    private Timestamp createdAt;
    
    @UpdateTimestamp
    private Timestamp updatedOn;
    
    @OneToOne
    @JoinColumn(name = "employee_id")
    private User user;
    
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();
    
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats = new ArrayList<>();
    
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}
