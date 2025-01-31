package com.parkease.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.parkease.dto.SessionDto;

public interface SessionService {
	
	BigDecimal markComplete(long id);

	List<SessionDto> getSessionsByDate(LocalDate date);
}
