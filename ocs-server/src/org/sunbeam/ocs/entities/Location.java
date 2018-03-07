package org.sunbeam.ocs.entities;

import javax.persistence.Column;
import javax.persistence.Id;

public class Location {
	private int pincode;		//PINCODE IN DATABASE
	private String city;		//CITY IN DATABASE
	private String district;	//DISTRICT IN DATABASE
	private String State;		//STATE IN DATABASE
	
	//CONSTRUCTORS
	
	public Location() {
	}

	public Location(int pincode, String city, String district, String state) {
		super();
		this.pincode = pincode;
		this.city = city;
		this.district = district;
		State = state;
	}

	//GETTERS AND SETTERS
	@Id
	@Column(name="PINCODE")
	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Column(name="CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="DISTRICT")
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name="STATE")
	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}	
	
}
