package com.parkease.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.parkease.customexception.ResourceNotFoundException;
import com.parkease.daos.UserDao;
import com.parkease.dto.ApiResponse;
import com.parkease.dto.UserDto;
import com.parkease.dto.UserLogInDto;
import com.parkease.pojos.User;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public UserDto signupUser(UserDto userDto) {
		User user=modelMapper.map(userDto, User.class);
		user.setPassword(encoder.encode(user.getPassword()));
		User persistentUser=userDao.save(user);
		return modelMapper.map(persistentUser,UserDto.class);
	}

	@Override
	public UserDto logInUser(@Valid UserLogInDto userLoginDto) {
		User user=userDao.findByEmail(userLoginDto.getEmail())
				.orElseThrow(() -> 
				new ResourceNotFoundException("User not found"));
		if (encoder.matches(userLoginDto.getPassword(), user.getPassword())) {
            return modelMapper.map(user,UserDto.class);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
	}

	@Override
	public List<UserDto> getAllUsers() {
		return userDao.findAll().stream()
				.map(user->modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse updateProfile(long id,UserDto userDto) {
		UserDto user=findByUserId(id);
		User persistantUser=modelMapper.map(userDto, User.class);
		persistantUser.setUserId(id);
		persistantUser.setPassword(user.getPassword());
	    userDao.save(persistantUser);
	    return new ApiResponse("Profile updated");
	}

	@Override
	public UserDto findByUserId(Long id) {
		return modelMapper.map(userDao.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("User not found")), UserDto.class);
	}

	@Override
	public ApiResponse blockUndblockUser(long id) {
		User user=userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		if(user.getStatus()==true)
			user.setStatus(false);
		else
			user.setStatus(true);
		return new ApiResponse("User status updated");
	}

}
