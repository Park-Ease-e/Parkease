package com.parkease.customexception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String msg){
		super(msg);
	}
}
