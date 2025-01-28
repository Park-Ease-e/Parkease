package com.parkease.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.parkease.daos.UserDao;
import com.parkease.dto.UserDto;
import com.parkease.pojos.User;

import jakarta.transaction.Transactional;


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

}
