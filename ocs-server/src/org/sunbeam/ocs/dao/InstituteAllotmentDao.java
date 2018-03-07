package org.sunbeam.ocs.dao;

import java.util.List;

import org.sunbeam.ocs.entities.InstituteAllotment;

public interface InstituteAllotmentDao {
	List<InstituteAllotment> getInstituteAllotmentListByInstituteCourseId(int instituteCourseId);
	InstituteAllotment getInstituteAllotmentByFormNumber(long formNumber);
	List<InstituteAllotment> getCompleteInstituteAllotmentList();
		
	int doInstituteAllocation(int round);
	
	int updateInstituteAllotment(InstituteAllotment instituteAllotment);
	
}
