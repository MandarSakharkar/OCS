package org.sunbeam.ocs.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class InstituteCourse implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3133238125926794875L;
	private int instituteCourseId;		//INSTITUTE_COURSE_ID IN DATABASE
	private int numberOfSeat;			//NUMBER_OF_SEATS IN DATABASE
	
	private Institute institute;
	private Course course;
	
	transient List<Preference> preferences;
	transient List<InstituteAllotment> instituteAllotments;
	
	public InstituteCourse() {
	}
	
	public InstituteCourse(int instituteCourseId, Institute institute, Course course, int numberOfSeat) {
		super();
		this.instituteCourseId = instituteCourseId;
		this.institute = institute;
		this.course = course;
		this.numberOfSeat = numberOfSeat;
		this.preferences = new ArrayList<>();
		this.instituteAllotments = new ArrayList<>();
	}

	@Id
	@Column(name="INSTITUTE_COURSE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getInstituteCourseId() {
		return instituteCourseId;
	}

	public void setInstituteCourseId(int instituteCourseId) {
		this.instituteCourseId = instituteCourseId;
	}

	@ManyToOne
	@JoinColumn(name="INSTITUTE_ID")
	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}

	@ManyToOne
	@JoinColumn(name="COURSE_ID")
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name="NUMBER_OF_SEATS")
	public int getNumberOfSeat() {
		return numberOfSeat;
	}

	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}

	@Transient
	@OneToMany(mappedBy="instituteCourse")
	public List<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}

	@Transient
	@OneToMany(mappedBy="instituteAllotment")
	public List<InstituteAllotment> getInstituteAllotments() {
		return instituteAllotments;
	}

	public void setInstituteAllotments(List<InstituteAllotment> instituteAllotments) {
		this.instituteAllotments = instituteAllotments;
	}	
}
