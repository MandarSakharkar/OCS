package org.sunbeam.ocs.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Course implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3552865492441949925L;
	private String courseId; 	//COURSE_ID IN DATABASE
	private String courseName; 	//COURSE_NAME IN DATABASE
	
	transient List<InstituteCourse> instituteCourses;
	
	//CONSTRUCTORS
	

	public Course() {
	}
	
	public Course(String courseId, String courseName) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.instituteCourses = new ArrayList<>();
	}

	//GETTERS AND SETTERS
	
	@Id
	@Column(name="COURSE_ID")
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Column(name="COURSE_NAME")
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	@Transient
	@OneToMany(mappedBy="course")
	public List<InstituteCourse> getInstituteCourses() {
		return instituteCourses;
	}

	public void setInstituteCourses(List<InstituteCourse> instituteCourses) {
		this.instituteCourses = instituteCourses;
	}
	
	
		
}
