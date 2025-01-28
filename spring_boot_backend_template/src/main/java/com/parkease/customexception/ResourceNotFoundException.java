package com.parkease.customexception;

public class ResourceNotFoundException extends RuntimeException {
	ResourceNotFoundException(String msg){
		super(msg);
	}
}
