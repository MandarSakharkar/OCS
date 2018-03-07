package org.sunbeam.ocs.services;

import java.io.Serializable;

import org.sunbeam.ocs.entities.Admin;
import org.sunbeam.ocs.entities.CounsellingProcessPhase;
import org.sunbeam.ocs.entities.Course;

public interface AdminService {
	Serializable addAdmin(Admin admin);
	Admin authenticateAdmin(Admin admin);
	int updateAdminPassword(Admin admin);
	int deleteAdmin(Admin admin);
	
	int setCounsellingProcessPhase(CounsellingProcessPhase counsellingProcessPhase);
	CounsellingProcessPhase getCounsellingProcessPhase();
	Serializable AddCourse(Course course);
	
	int doInstituteAllocation(int round);
	
}
