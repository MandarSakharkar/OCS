package org.sunbeam.ocs.services;

import java.io.Serializable;
import java.util.List;

import org.sunbeam.ocs.entities.CounsellingProcessPhase;
import org.sunbeam.ocs.entities.InstituteAllotment;
import org.sunbeam.ocs.entities.Preference;
import org.sunbeam.ocs.entities.Student;
import org.sunbeam.ocs.entities.StudentAccount;

public interface StudentService {

	//student account
	Serializable addStudentAccount(StudentAccount studentAccount); 				//add student account to the database, candidate registration service can use this
	StudentAccount authenticateStudent(StudentAccount studentAccount);			//authenticate student from credentials, candidate login service can use this
	int changeStudentPassword(StudentAccount studentAccount);					//change password of candidate. 
	StudentAccount getStudentAccount(StudentAccount studentAccount);
	
	//student detail
	Serializable addStudent(Student student);	//fill the student details into the database
	int updateStudent(Student student);			//update the student details
	Student getStudent(long formNumber);		//get StudentAccount Detail by formNumber
	
	
	//preferences given by student
	
	Serializable addStudentPreference(Preference preference);
	int updateStudentPreference(Preference preference);
	int deleteStudentPreference(Preference preference);
	Preference getStudentPreferenceDetail(long preferenceId);
	
	Serializable savePreference(Preference preference);
	
	CounsellingProcessPhase getCounsellingProcessPhase();
	List<Preference> getPreferencesByFormNumber(long formNumber);
	InstituteAllotment getInstituteAllotmentByFormNumber(long formNumber);
	
}
