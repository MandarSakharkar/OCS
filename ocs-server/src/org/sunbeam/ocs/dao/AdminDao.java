package org.sunbeam.ocs.dao;

import java.io.Serializable;

import org.sunbeam.ocs.entities.Admin;


public interface AdminDao {
	Serializable addAdmin(Admin admin);
	Admin authenticateAdmin(Admin admin);
	int updateAdminPassword(Admin admin);
	int deleteAdmin(Admin admin);
	
}
