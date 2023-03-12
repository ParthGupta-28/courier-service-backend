package com.courierservice.courierservicebackend.userdetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class UserDetails {
	
	
	@Id
	private String email;
	
	@NotNull
	private String name;
	
	@NotNull
	private String password;
	
	@Size(min = 10, max=10)
	@NotNull
	private String phoneNo;
	
	@NotNull
	private String state;
	
	@NotNull
	private String city;
	
	@NotNull
	private String pincode;
	
	@NotNull
	private String address;
	
	
	public UserDetails(String email, String name, String password, String phoneNo, String state, String city,
			String pincode, String address) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.phoneNo = phoneNo;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.address = address;
	}
	
	public UserDetails()
	{
		
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
