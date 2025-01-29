package com.parkease.services;

import java.util.List;

import com.parkease.dto.ApiResponse;
import com.parkease.dto.FaqDto;

public interface FaqService {

	FaqDto insertFAQ(FaqDto faqDto);

	List<FaqDto> getAllFAQs();

	ApiResponse deleteFAQ(long id);

}
