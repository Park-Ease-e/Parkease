package com.parkease.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkease.customexception.ResourceNotFoundException;
import com.parkease.daos.FaqDao;
import com.parkease.dto.ApiResponse;
import com.parkease.dto.FaqDto;
import com.parkease.dto.UserDto;
import com.parkease.pojos.Faq;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FaqServiceImpl implements FaqService{
	
	@Autowired
	private FaqDao faqDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public FaqDto insertFAQ(FaqDto faqDto) {
		return modelMapper.map(faqDao.save(modelMapper.map(faqDto, Faq.class)), FaqDto.class);
	}

	@Override
	public List<FaqDto> getAllFAQs() {
		return faqDao.findAll().stream()
				.map(faq->modelMapper.map(faq, FaqDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse deleteFAQ(long id) {
		faqDao.delete(faqDao.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("FAQ not found or Invalid FAQ Id")));
		return new ApiResponse("FAQ deleted successfully.");
	}

}
