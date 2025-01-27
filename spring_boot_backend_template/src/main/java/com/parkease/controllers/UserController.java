package com.parkease.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parkease.dto.UserDto;
import com.parkease.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired	
	private UserService userService;   
	
	private static final String UPLOAD_DIR = "uploads/profile_images/";
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserDto userDto)
	{
		UserDto resp=userService.signupUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(resp);
	}
	
	@PutMapping(value="/upload/{id}" , consumes = {"multipart/form-data"})
	public ResponseEntity<?> UploadProfile(@RequestPart MultipartFile file)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		try {
            if (file != null && !file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                Path filePath = Paths.get(UPLOAD_DIR + fileName);

                Files.createDirectories(filePath.getParent());

                Files.write(filePath, file.getBytes());

                return ResponseEntity.ok("Profile updated successfully");
            }
		}catch(IOException e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("hi");
	}
}
