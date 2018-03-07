package org.sunbeam.ocs.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sunbeam.ocs.entities.Course;

@Repository
public class CourseDaoImpl implements CourseDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Course> getCourseList() {
		
		/*get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 *thread class not provided or number of collections in pool not provided. 
		 */
		Session session = sessionFactory.getCurrentSession();


		List<Course> courseList = session.createQuery("from Course c ").getResultList();
				
		return courseList;
		
	}

	@Override
	public Serializable addCourse(Course course) {
		return sessionFactory.getCurrentSession().save(course);
	}

}
