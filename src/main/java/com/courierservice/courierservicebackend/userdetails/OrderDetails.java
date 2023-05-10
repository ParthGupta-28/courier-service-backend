package com.courierservice.courierservicebackend.userdetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class OrderDetails {

	@Id
	private String orderID;
	
	@NotNull
	@JsonProperty("nameOfSender")
	private String senderName;
	
	@NotNull
	@JsonProperty("cityOfSender")
	private String senderCity;
	
	@NotNull
	@JsonProperty("stateOfSender")
	private String senderState;
	
	@NotNull
	@JsonProperty("pincodeOfSender")
	private String senderPincode;
	
	@NotNull
	@JsonProperty("addressOfSender")
	private String senderAddress;
	
	@NotNull
	@Size(max = 10, min = 10, message = "Sender Phone number must be of 10 digits")
	@JsonProperty("phoneOfSender")
	private String senderPhoneno;
	
	@NotNull
	@JsonProperty("nameOfReceiver")
	private String receiverName;
	
	@NotNull
	@JsonProperty("cityOfReceiver")
	private String receiverCity;
	
	@NotNull
	@JsonProperty("stateOfReceiver")
	private String receiverState;
	
	@NotNull
	@JsonProperty("pincodeOfReceiver")
	private String receiverPincode;
	
	@NotNull
	@JsonProperty("addressOfReceiver")
	private String receiverAddress;
	
	@NotNull
	@Size(max = 10, min = 10, message = "Receiver Phone number must be of 10 digits")
	@JsonProperty("phoneOfReceiver")
	private String receiverPhoneno;
	
	private String currentLocation;
	
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private UserDetails user;
	
	public OrderDetails(String orderID, @NotNull String senderName, @NotNull String senderCity,
			@NotNull String senderState, @NotNull String senderPincode, @NotNull String senderAddress,
			@NotNull @Size(max = 10, min = 10) String senderPhoneno, @NotNull String receiverName,
			@NotNull String receiverCity, @NotNull String receiverState, @NotNull String receiverPincode,
			@NotNull String receiverAddress, @NotNull @Size(max = 10, min = 10) String receiverPhoneno) {
		super();
		this.orderID = orderID;
		this.senderName = senderName;
		this.senderCity = senderCity;
		this.senderState = senderState;
		this.senderPincode = senderPincode;
		this.senderAddress = senderAddress;
		this.senderPhoneno = senderPhoneno;
		this.receiverName = receiverName;
		this.receiverCity = receiverCity;
		this.receiverState = receiverState;
		this.receiverPincode = receiverPincode;
		this.receiverAddress = receiverAddress;
		this.receiverPhoneno = receiverPhoneno;
	}

	public OrderDetails() {

	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderCity() {
		return senderCity;
	}

	public void setSenderCity(String senderCity) {
		this.senderCity = senderCity;
	}

	public String getSenderState() {
		return senderState;
	}

	public void setSenderState(String senderState) {
		this.senderState = senderState;
	}

	public String getSenderPincode() {
		return senderPincode;
	}

	public void setSenderPincode(String senderPincode) {
		this.senderPincode = senderPincode;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getSenderPhoneno() {
		return senderPhoneno;
	}

	public void setSenderPhoneno(String senderPhoneno) {
		this.senderPhoneno = senderPhoneno;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverCity() {
		return receiverCity;
	}

	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}

	public String getReceiverState() {
		return receiverState;
	}

	public void setReceiverState(String receiverState) {
		this.receiverState = receiverState;
	}

	public String getReceiverPincode() {
		return receiverPincode;
	}

	public void setReceiverPincode(String receiverPincode) {
		this.receiverPincode = receiverPincode;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverPhoneno() {
		return receiverPhoneno;
	}

	public void setReceiverPhoneno(String receiverPhoneno) {
		this.receiverPhoneno = receiverPhoneno;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}
	

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderID=" + orderID + ", senderName=" + senderName + ", senderCity=" + senderCity
				+ ", senderState=" + senderState + ", senderPincode=" + senderPincode + ", senderAddress="
				+ senderAddress + ", senderPhoneno=" + senderPhoneno + ", receiverName=" + receiverName
				+ ", receiverCity=" + receiverCity + ", receiverState=" + receiverState + ", receiverPincode="
				+ receiverPincode + ", receiverAddress=" + receiverAddress + ", receiverPhoneno=" + receiverPhoneno
				+ ", currentLocation=" + currentLocation + ", status=" + status + ", user=" + user + "]";
	}
	
}
