package org.sunbeam.ocs.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3156113818222754235L;
	private long adharNumber; 		//ADHAR_NUMBER IN  DATABASE
	private char gender; 			//GENDER IN  DATABASE
	private String category; 		//CATEGORY IN  DATABASE
	private Date dateOfBirth; 		//DATE_OF_BIRTH IN  DATABASE
	private String address; 		//ADDRESS IN  DATABASE
	private int pincode; 			//PINCODE IN  DATABASE
	private long eCatRollNumber; 	//ECAT_ROLL_NUMBER IN  DATABASE
	private long eCatRank; 			//ECAT RANK IN  DATABASE
	private String degree; 			//DEGREE IN  DATABASE
	private float degreePercentage;	//DEGREE_PERCENTAGE IN  DATABASE
	private String photo;  			//PHOTO IN  DATABASE
	private int isValidated;		//IS_VALIDATED IN DATABASE
	
	//constructors
	
	private StudentAccount studentAccount;
	
	
	@OneToOne
	@JoinColumn(name="FORM_NUMBER")
	public StudentAccount getStudentAccount() {
		return studentAccount;
	}

	public void setStudentAccount(StudentAccount studentAccount) {
		this.studentAccount = studentAccount;
	}

	public Student() {
		studentAccount = new StudentAccount();
	}
	
	public Student(StudentAccount studentAccount, long adharNumber, char gender, String category, Date dateOfBirth,
			String address, int pincode, long eCatRollNumber, long eCatRank, String degree,
			float degreePercentage, String photo, int isValidated) 
	{
		this.studentAccount=studentAccount;
		this.adharNumber = adharNumber;
		this.gender = gender;
		this.category = category;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.pincode = pincode;
		this.eCatRollNumber = eCatRollNumber;
		this.eCatRank = eCatRank;
		this.degree = degree;
		this.degreePercentage = degreePercentage;
		this.photo = photo;
		this.isValidated = isValidated;
	}

	//getters and setters
	
	/*@Column(name="FORM_NUMBER")
	public long getFormNumber() {
		return formNumber;
	}

	public void setFormNumber(long formNumber) {
		this.formNumber = formNumber;
	}*/

	@Id
	@Column(name="ADHAR_NUMBER")
	public long getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(long adharNumber) {
		this.adharNumber = adharNumber;
	}
	
	@Column(name="GENDER")
	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Column(name="CATEGORY")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name="DATE_OF_BIRTH")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="PINCODE")
	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Column(name="ECAT_ROLL_NUMBER")
	public long geteCatRollNumber() {
		return eCatRollNumber;
	}

	public void seteCatRollNumber(long eCatRollNumber) {
		this.eCatRollNumber = eCatRollNumber;
	}

	@Column(name="ECAT_RANK")
	public long geteCatRank() {
		return eCatRank;
	}

	public void seteCatRank(long eCatRank) {
		this.eCatRank = eCatRank;
	}

	@Column(name="DEGREE")
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Column(name="DEGREE_PERCENTAGE")
	public float getDegreePercentage() {
		return degreePercentage;
	}

	public void setDegreePercentage(float degreePercentage) {
		this.degreePercentage = degreePercentage;
	}

	@Column(name="PHOTO")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	@Column(name="IS_VALIDATED")
	public int getIsValidated() {
		return isValidated;
	}

	public void setIsValidated(int isValidated) {
		this.isValidated = isValidated;
	}
}
