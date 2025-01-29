package com.parkease.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.parkease.dto.UserDto;
import com.parkease.dto.UserLogInDto;
import com.parkease.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired	
	private UserService userService; 
	
	private static final String UPLOAD_DIR = "uploads/profile_images/";
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody @Valid UserDto userDto)
	{
		UserDto resp=userService.signupUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(resp);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody @Valid UserLogInDto userLoginDto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(userService.logInUser(userLoginDto));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllUsers()
	{
		List<UserDto> userDtos=userService.getAllUsers();
		if(userDtos.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(userDtos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id)
	{
		return ResponseEntity.ok(userService.findByUserId(id));
	}
	
	@PutMapping("/status/{id}")
	public ResponseEntity<?> blockUnBlockUser(@PathVariable Long id)
	{
		return ResponseEntity.ok(userService.blockUndblockUser(id));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id,@RequestBody UserDto userDto)
	{
		return ResponseEntity.ok(userService.updateProfile(id,userDto));
	}
	
	@PutMapping(value="/upload/{id}" , consumes = {"multipart/form-data"},produces = {"application/json"})
	public ResponseEntity<?> uploadProfile(@RequestPart MultipartFile file,@PathVariable Long id) throws IOException
	{
		UserDto userDto=userService.findByUserId(id);
            if (file != null && !file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                Path filePath = Paths.get(UPLOAD_DIR + fileName);

                Files.createDirectories(filePath.getParent());

                Files.write(filePath, file.getBytes());
                userDto.setProfileImagePath(fileName);

                return ResponseEntity.ok(userService.updateProfile(id,userDto));
            }
            return ResponseEntity.badRequest().body("File is empty or not provided");
	}
}
