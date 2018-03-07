package org.sunbeam.ocs.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Institute implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6439186126239876066L;
	
	
	private int instituteId; 				//INSTITUTE IN DATABASE
	private String instituteName; 			//INSTITUTE_NAME IN DATABASE
	private String instituteAddress; 		//INSTITUTE_ADDRESS IN DATABASE
	private int pincode; 					//PINCODE IN DATABASE
	private long instituteContactNumber; 	//INSTITUTE_CONTACT_NUMBER IN DATABASE
	private String instituteEmailId; 		//INSTITUTE_EMAIL_ID IN DATABASE
	
	//CONSTRUCTORS
	
	transient List<InstituteCourse> instituteCourses;
	
	public Institute() {
	}
	
	
	public Institute(int instituteId, String instituteName, String instituteAddress, int pincode,
			long instituteContactNumber, String instituteEmailId) 
	{
		this.instituteId = instituteId;
		this.instituteName = instituteName;
		this.instituteAddress = instituteAddress;
		this.pincode = pincode;
		this.instituteContactNumber = instituteContactNumber;
		this.instituteEmailId = instituteEmailId;
		this.instituteCourses = new ArrayList<>();
	}
	
	//GETTERS AND SETTERS
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INSTITUTE_ID")
	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int institute) {
		this.instituteId = institute;
	}

	@Column(name="INSTITUTE_NAME")
	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	
	@Column(name="INSTITUTE_ADDRESS")
	public String getInstituteAddress() {
		return instituteAddress;
	}

	public void setInstituteAddress(String instituteAddress) {
		this.instituteAddress = instituteAddress;
	}

	@Column(name="PINCODE")
	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Column(name="INSTITUTE_CONTACT_NUMBER")
	public long getInstituteContactNumber() {
		return instituteContactNumber;
	}

	public void setInstituteContactNumber(long instituteContactNumber) {
		this.instituteContactNumber = instituteContactNumber;
	}

	@Column(name="INSTITUTE_EMAIL_ID")
	public String getInstituteEmailId() {
		return instituteEmailId;
	}

	public void setInstituteEmailId(String instituteEmailId) {
		this.instituteEmailId = instituteEmailId;
	}


	@Transient
	@OneToMany(mappedBy="institute")
	public List<InstituteCourse> getInstituteCourses() {
		return instituteCourses;
	}


	public void setInstituteCourses(List<InstituteCourse> instituteCourses) {
		this.instituteCourses = instituteCourses;
	}
	
		
	
}
