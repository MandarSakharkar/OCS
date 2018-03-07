package org.sunbeam.ocs.services;

import java.io.Serializable;
import java.util.List;

import org.sunbeam.ocs.entities.CounsellingProcessPhase;
import org.sunbeam.ocs.entities.Course;
import org.sunbeam.ocs.entities.Institute;
import org.sunbeam.ocs.entities.InstituteAllotment;
import org.sunbeam.ocs.entities.InstituteCourse;
import org.sunbeam.ocs.entities.InstituteLogin;
import org.sunbeam.ocs.entities.Student;

public interface InstituteService {
	
	//institute detail
	Serializable registerInstitute(Institute institute);
	Institute authenticateInstitute(InstituteLogin instituteLogin);
	boolean updateInstituteDetails(Institute institute);
	
	//institute account
	boolean changeInstitutePassword(InstituteLogin instituteLogin);
	Serializable addInstituteAccount(InstituteLogin instituteLogin);
	
	
	//institute course
	Serializable addInstituteCourse(InstituteCourse instituteCourse);
	int updateInstituteCourse(InstituteCourse instituteCourse);
	InstituteCourse getInstituteCourse(int instituteCourseId);
	int deleteInstituteCourse(InstituteCourse instituteCourse);
	List<Course> getCourseList();
	List<InstituteCourse> getInstituteCourseByCourseId(String courseId);
	List<InstituteCourse> getInstituteCourseByInstituteId(int instituteId);	
	
	CounsellingProcessPhase getCounsellingProcessPhase();
	int ValidateStudent(Student student);
	Student getStudentDetails(long formNumber);
	
	List<InstituteAllotment> getInstituteAllotmentListByInstituteCourseId(int instituteCourseId);
	int updateInstituteAllotment(InstituteAllotment instituteAllotment);
	InstituteAllotment getInstituteAllotmentByFormNumber(long formNumber);
	
}
