package org.sunbeam.ocs.dao;

import java.io.Serializable;
import java.util.List;

import org.sunbeam.ocs.entities.Preference;
import org.sunbeam.ocs.entities.Student;

public interface StudentDao {
	
	Serializable addStudent(Student student);
	int updateStudent(Student student);
	Student getStudent(long formNumber);
	int deleteStudent(Student student);
	List<Student> getStudentsList();
}
