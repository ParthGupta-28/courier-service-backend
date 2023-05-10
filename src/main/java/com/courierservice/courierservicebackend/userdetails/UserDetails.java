package com.courierservice.courierservicebackend.userdetails;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class UserDetails {
	
	
	@Id
	private String email;
	
	@NotNull
	@JsonProperty("nameOfSender")
	private String name;
	
	@NotNull
	@JsonProperty(access = Access.WRITE_ONLY)
	@Size(min = 8, message = "Password must be of 8 characters")
	private String password;
	
	@Size(min = 10, max=10, message = "Phone number must be of 10 digits")
	@NotNull
	@JsonProperty("phoneOfSender")
	private String phoneNo;
	
	@NotNull
	@JsonProperty("stateOfSender")
	private String state;
	
	@NotNull
	@JsonProperty("cityOfSender")
	private String city;
	
	@NotNull
	@JsonProperty("pincodeOfSender")
	private String pincode;
	
	@NotNull
	@JsonProperty("addressOfSender")
	private String address;
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<OrderDetails> order;
	
	
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

	public List<OrderDetails> getOrder() {
		return order;
	}

	public void setOrder(List<OrderDetails> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "UserDetails [email=" + email + ", name=" + name + ", password=" + password + ", phoneNo=" + phoneNo
				+ ", state=" + state + ", city=" + city + ", pincode=" + pincode + ", address=" + address + ", order="
				+ order + "]";
	}
}
