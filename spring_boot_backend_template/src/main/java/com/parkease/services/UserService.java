package com.parkease.services;

import java.util.List;

import com.parkease.dto.ApiResponse;
import com.parkease.dto.UserDto;
import com.parkease.dto.UserLogInDto;

import jakarta.validation.Valid;

public interface UserService {

	UserDto signupUser(UserDto userDto);

	UserDto logInUser(@Valid UserLogInDto userLoginDto);

	List<UserDto> getAllUsers();

	ApiResponse updateProfile(long id,UserDto userDto);

	UserDto findByUserId(Long id);

	ApiResponse blockUndblockUser(long id);

	ApiResponse forgetPassword(UserDto userDto);

}
