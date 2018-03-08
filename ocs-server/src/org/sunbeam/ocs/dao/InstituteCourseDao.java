package org.sunbeam.ocs.dao;

import java.io.Serializable;
import java.util.List;

import org.sunbeam.ocs.entities.InstituteCourse;

public interface InstituteCourseDao {
	Serializable addInstituteCourse(InstituteCourse instituteCourse);
	int updateInstituteCourse(InstituteCourse instituteCourse);
	InstituteCourse getInstituteCourse(int instituteCourseId);
	int deleteInstituteCourse(InstituteCourse instituteCourse);
	List<InstituteCourse> getInstituteCourseListByCourseId(String courseId);
	List<InstituteCourse> getInstituteCourseListByInstituteId(int instituteId);	
}
