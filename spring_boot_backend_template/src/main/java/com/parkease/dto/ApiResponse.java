package com.parkease.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ApiResponse {
	private LocalDateTime timeStamp;
	private String msg;
	public ApiResponse(String message) {
		super();
		this.msg = msg;
		this.timeStamp=LocalDateTime.now();
	}
}
