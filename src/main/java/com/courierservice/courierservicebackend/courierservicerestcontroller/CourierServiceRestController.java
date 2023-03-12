package com.courierservice.courierservicebackend.courierservicerestcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.courierservice.courierservicebackend.exception.UserAlreadyExits;
import com.courierservice.courierservicebackend.userdetails.UserDetails;
import com.courierservice.courierservicebackend.userdetails.UserDetailsRepository;

import jakarta.validation.Valid;

@RestController
public class CourierServiceRestController {

	@Autowired
	private UserDetailsRepository details;
	
	@PostMapping(path="")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createUser( @Valid @RequestBody  UserDetails detail) {
		
	Optional<UserDetails> checkemail=details.findById(detail.getEmail());
		if(!checkemail.isEmpty()) {
			
			throw new UserAlreadyExits("User Already Exits");
		}
		details.save(detail);
	}
}
