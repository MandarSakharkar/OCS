package org.sunbeam.ocs.dao;

import java.io.Serializable;
import java.util.List;

import org.sunbeam.ocs.entities.Course;

public interface CourseDao {
	List<Course> getCourseList();
	Serializable addCourse(Course course);
}
