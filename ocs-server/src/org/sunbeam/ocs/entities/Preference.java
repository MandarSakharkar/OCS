package org.sunbeam.ocs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Preference {

	private long preferenceId;			//PREFERENCE_ID IN DATABASE
	private int preferenceNumber;		//PREFERENCE_NUMBER IN DATABASE
	private int roundNumber;			//ROUND_NUMBER IN DATABASE
	

	private InstituteCourse instituteCourse;
	private StudentAccount studentAccount;
	
	public Preference() {
		
	}


	public Preference(long preferenceId , InstituteCourse instituteCourse, int preferenceNumber,StudentAccount studentAccount,
			int roundNumber) {
		super();
		this.preferenceId = preferenceId;
		this.instituteCourse = instituteCourse;
		this.preferenceNumber = preferenceNumber;
		this.studentAccount = studentAccount;
	}
	
	//getters and setters

	@Id
	@Column(name="PREFERENCE_ID")
	public long getPreferenceId() {
		return preferenceId;
	}


	public void setPreferenceId(long preferenceId) {
		this.preferenceId = preferenceId;
	}

	@ManyToOne
	@JoinColumn(name="INSTITUTE_COURSE_ID")
	public InstituteCourse getInstituteCourse() {
		return instituteCourse;
	}


	public void setInstituteCourse(InstituteCourse instituteCourse) {
		this.instituteCourse = instituteCourse;
	}


	@ManyToOne
	@JoinColumn(name="FORM_NUMBER")
	public StudentAccount getStudentAccount() {
		return studentAccount;
	}


	public void setStudentAccount(StudentAccount studentAccount) {
		this.studentAccount = studentAccount;
	}



	@Column(name="PREFERENCE_NUMBER")
	public int getPreferenceNumber() {
		return preferenceNumber;
	}


	public void setPreferenceNumber(int preferenceNumber) {
		this.preferenceNumber = preferenceNumber;
	}

	


	@Column(name="ROUND_NUMBER")
	public int getRoundNumber() {
		return roundNumber;
	}


	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}	

}
