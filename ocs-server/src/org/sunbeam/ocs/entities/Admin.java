package org.sunbeam.ocs.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7329879356492756362L;
	
	private String adminId;
	private String password;
	
	public Admin() {
	}

	public Admin(String adminId, String password) {
		super();
		this.adminId = adminId;
		this.password = password;
	}

	@Id
	@Column(name="ADMIN_ID")
	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
