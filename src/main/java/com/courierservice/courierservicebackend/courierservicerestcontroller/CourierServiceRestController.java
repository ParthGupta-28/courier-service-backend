package com.courierservice.courierservicebackend.courierservicerestcontroller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.courierservice.courierservicebackend.exception.OrderNotFoundException;
import com.courierservice.courierservicebackend.exception.PasswordDoesNotMatch;
import com.courierservice.courierservicebackend.exception.UserAlreadyExits;
import com.courierservice.courierservicebackend.exception.UserNotFoundException;
import com.courierservice.courierservicebackend.userdetails.OrderDetails;
import com.courierservice.courierservicebackend.userdetails.OrderDetailsRepository;
import com.courierservice.courierservicebackend.userdetails.UserDetails;
import com.courierservice.courierservicebackend.userdetails.UserDetailsRepository;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
public class CourierServiceRestController {

	@Autowired
	private UserDetailsRepository userDetails;

	@Autowired
	private OrderDetailsRepository orderDetails;


	@PostMapping(path = "/users")
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserDetails createUser(@Valid @RequestBody UserDetails detail) {

		Optional<UserDetails> checkemail = userDetails.findById(detail.getEmail());
		if (!checkemail.isEmpty()) {

			throw new UserAlreadyExits("User Already Exits");
		}
		userDetails.save(detail);
		return detail;
	}

	@GetMapping(path = "/users/{email}/{password}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public UserDetails findUser(@PathVariable String email, @PathVariable String password) {

		Optional<UserDetails> find = userDetails.findById(email);

		if (find.isEmpty()) {

			throw new UserNotFoundException("User does not Exits");
		}
		UserDetails user = find.get();
		if (!user.getPassword().equals(password)) {

			throw new PasswordDoesNotMatch("Incorrect Password");
		}

		return user;
	}

	@PostMapping(path = "/users/{email}/order")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String createOrder(@Valid @RequestBody OrderDetails orderDetail, @PathVariable String email) {

		Optional<UserDetails> searchuser = userDetails.findById(email);
		if (searchuser.isEmpty()) {
			throw new UserNotFoundException("User Does Not Exits");
		}

		orderDetail.setUser(searchuser.get());
		UUID id = UUID.randomUUID();
		orderDetail.setOrderID(id.toString());
		orderDetail.setStatus("In Progress");
		String currentLocation = orderDetail.getSenderAddress()+", "+orderDetail.getSenderCity()+", "+orderDetail.getSenderPincode()+", India";
		orderDetail.setCurrentLocation(currentLocation);
		orderDetails.save(orderDetail);

		return orderDetail.getOrderID();
	}

	@GetMapping(path = "/users/{email}/order")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public List<OrderDetails> getOrders(@PathVariable String email) {

		Optional<UserDetails> finduser = userDetails.findById(email);
		if (finduser.isEmpty()) {
			throw new UserNotFoundException("User Does Not Exits");

		}
		UserDetails user = finduser.get();
		return user.getOrder();
	}

	@PutMapping(path = "/users/update/{email}/{password}")
	@ResponseStatus(code = HttpStatus.OK)
	public UserDetails updateById(@RequestBody UserDetails user, @PathVariable String email,
			@PathVariable String password) {
		user.setEmail(email);
		Optional<UserDetails> searchById = userDetails.findById(email);
		if (searchById.isEmpty()) {

			throw new UserNotFoundException("Incorrect Email Id");

		}
		UserDetails founduser = searchById.get();
		if (!founduser.getPassword().equals(password)) {

			throw new PasswordDoesNotMatch("Incorrect Password");
		}
		userDetails.save(user);
		return user;

	}

	@GetMapping(path = "users/{orderId}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public OrderDetails findByOrderId(@PathVariable String orderId) {

		Optional<OrderDetails> getOrderDetails = orderDetails.findById(orderId);
		if (getOrderDetails.isEmpty()) {

			throw new OrderNotFoundException("Incorrect Order Id");
		}
		OrderDetails detail = getOrderDetails.get();
		return detail;
	}

}
