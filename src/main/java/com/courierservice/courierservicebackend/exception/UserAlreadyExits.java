package com.courierservice.courierservicebackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class UserAlreadyExits extends RuntimeException {
	
	public UserAlreadyExits(String msg)
	{
		super(msg);
	}

}
