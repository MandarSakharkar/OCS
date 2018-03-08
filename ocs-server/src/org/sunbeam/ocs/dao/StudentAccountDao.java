package org.sunbeam.ocs.dao;


import java.io.Serializable;

import org.sunbeam.ocs.entities.StudentAccount;

public interface StudentAccountDao {
	
	Serializable addStudentAccount(StudentAccount studentAccount); 			//add candidate to the database, candidate registration service can use this
	StudentAccount authenticateStudent(StudentAccount studentAccount);				//get candidate from database, candidate login service can use this
	int updateStudentPassword(StudentAccount studentAccount); 			//change password of candidate's account
	StudentAccount getStudentAccount(StudentAccount studentAccount);
	
}
