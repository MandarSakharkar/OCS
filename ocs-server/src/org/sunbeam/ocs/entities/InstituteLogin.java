package org.sunbeam.ocs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InstituteLogin {

	private String instituteLoginId; 	//INSTITUTE_LOGIN_ID IN DATABASE
	private int instituteId; 		//INSTITUTE_ID IN DATABASE
	private String password; 		//PASSWORD IN DATABASE
	
	
	//CONSTRUCTORS
	
	public InstituteLogin() {
	}
	
	public InstituteLogin(String instituteLoginId, int instituteId, String password) {
		this.instituteLoginId = instituteLoginId;
		this.instituteId = instituteId;
		this.password = password;
	}
	
	//GETTERS AND SETTERS

	@Id
	@Column(name="INSTITUTE_LOGIN_ID")
	public String getInstituteLoginId() {
		return instituteLoginId;
	}

	public void setInstituteLoginId(String instituteLoginId) {
		this.instituteLoginId = instituteLoginId;
	}
	
	@Column(name="INSTITUTE_ID")
	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
