package org.sunbeam.ocs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class InstituteAllotment {

	private int allotmentId;							//ALLOTMENT_ID IN DATABASE
	private StudentAccount studentAccount;
	private Preference preference;
	private InstituteCourse instituteCourse;			//INSTITUTE_COURSE_ID IN DATABASE
	private int isAdmissionConfirmed;					//IS_ADMISSION_CONFIRMED IN DATABASE
	
	
	public InstituteAllotment() {
	}

	

	public InstituteAllotment(int allotmentId, StudentAccount studentAccount, Preference preference,
			InstituteCourse instituteCourse, int isAdmissionConfirmed) {
		super();
		this.allotmentId = allotmentId;
		this.studentAccount = studentAccount;
		this.preference = preference;
		this.instituteCourse = instituteCourse;
		this.isAdmissionConfirmed = isAdmissionConfirmed;
	}



	@Id
	@Column(name="ALLOTMENT_ID")
	public int getAllotmentId() {
		return allotmentId;
	}



	public void setAllotmentId(int allotmentId) {
		this.allotmentId = allotmentId;
	}

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FORM_NUMBER")
	public StudentAccount getStudentAccount() {
		return studentAccount;
	}
	public void setStudentAccount(StudentAccount studentAccount) {
		this.studentAccount = studentAccount;
	}



	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PREFERENCE_ID")
	public Preference getPreference() {
		return preference;
	}
	public void setPreference(Preference preference) {
		this.preference = preference;
	}

	@JoinColumn(name="INSTITUTE_COURSE_ID")
	@ManyToOne(fetch=FetchType.EAGER)
	public InstituteCourse getInstituteCourse() {
		return instituteCourse;
	}

	public void setInstituteCourse(InstituteCourse instituteCourse) {
		this.instituteCourse = instituteCourse;
	}

	@Column(name="IS_ADMISSION_CONFIRMED")
	public int getIsAdmissionConfirmed() {
		return isAdmissionConfirmed;
	}



	public void setIsAdmissionConfirmed(int isAdmissionConfirmed) {
		this.isAdmissionConfirmed = isAdmissionConfirmed;
	}

	
	
	

}
