package com.courierservice.courierservicebackend.exception;

public class UserAlreadyExits extends RuntimeException {
	
	public UserAlreadyExits(String msg)
	{
		super(msg);
	}

}
