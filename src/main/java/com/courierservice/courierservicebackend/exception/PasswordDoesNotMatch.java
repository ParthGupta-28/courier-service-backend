package com.courierservice.courierservicebackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class PasswordDoesNotMatch extends RuntimeException {
	
	public PasswordDoesNotMatch(String msg)
	{
		super(msg);
	}

}
