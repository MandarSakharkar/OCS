package org.sunbeam.ocs.entities;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.sunbeam.ocs.exceptions.InvalidDataException;

import com.fasterxml.jackson.annotation.JacksonInject;

@Entity
public class StudentAccount {
	
	private long formNumber;    //FORM_NUMBER IN DATABASE
	private String fullName;    //FULL_NAME IN DATABASE
	private long contactNumber; //CONTACT_NUMBER IN DATABASE
	private String emailId;     //EMAIL_ID IN DATABASE
	private String password;    //PASSWORD IN DATABASE
	
	
	transient List<Preference> preferences;
	
	private Student student;

	private InstituteAllotment instituteAllotment;
	
	//constructors
	
	public StudentAccount() {
	}
	
	public StudentAccount(long formNumber, String fullName, long contactNumber, String emailId, String password) {
		this.formNumber = formNumber;
		this.fullName = fullName;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.password = password;
		this.preferences = new ArrayList<>();
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FORM_NUMBER")
	public long getFormNumber() {
		return formNumber;
	}
	
	public void setFormNumber(long formNumber) {
		this.formNumber = formNumber;
	}

	@Column(name="FULL_NAME")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) throws InvalidDataException {
		String NAMEREGEX = "^[a-zA-Z\\s]+$";
		if(fullName.matches(NAMEREGEX))
			this.fullName = fullName;
		else
			throw new InvalidDataException();
	}

	@Column(name="CONTACT_NUMBER")
	public long getContactNumber(){
		return contactNumber;
	}

	public void setContactNumber(long contactNumber)throws NumberFormatException{
		this.contactNumber = contactNumber;
	}

	@Column(name="EMAIL_ID")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String eMailId) throws InvalidDataException {
				
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if(eMailId.matches(EMAIL_REGEX))
			this.emailId = eMailId;
		else
			throw new InvalidDataException("Not a valid email");
	}

	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	@Transient
	@OneToMany(mappedBy="studentAccount",fetch=FetchType.EAGER)
	public List<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}

	@OneToOne(mappedBy="studentAccount")
	@Transient
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}	
	
	@OneToOne(mappedBy="studentAccount",fetch=FetchType.EAGER)
	@Transient
	public InstituteAllotment getInstituteAllotment() {
		return instituteAllotment;
	}

	public void setInstituteAllotment(InstituteAllotment instituteAllotment) {
		this.instituteAllotment = instituteAllotment;
	}
}
