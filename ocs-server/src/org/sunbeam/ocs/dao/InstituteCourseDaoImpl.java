package org.sunbeam.ocs.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sunbeam.ocs.entities.InstituteCourse;

@Repository
public class InstituteCourseDaoImpl implements InstituteCourseDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Serializable addInstituteCourse(InstituteCourse instituteCourse) {
		
		
		/*get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 *thread class not provided or number of collections in pool not provided. 
		 */
		Session session = sessionFactory.getCurrentSession();
		
		/*
		 * add institute course to database
		 */
		Serializable result = session.save(instituteCourse);
		
		return result;
	}

	@Override
	public int updateInstituteCourse(InstituteCourse instituteCourse) {
		/*get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 *thread class not provided or number of collections in pool not provided. 
		 */
		Session session = sessionFactory.getCurrentSession();
		/*
		 * update institute course in database
		 */
		try{
			session.update(instituteCourse);		
			return 1;
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public InstituteCourse getInstituteCourse(int instituteCourseId) {
		/*get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 *thread class not provided or number of collections in pool not provided. 
		 */
		
		Session session = sessionFactory.getCurrentSession();
		
		//return the institute by instituteId
		return session.byId(InstituteCourse.class).load(instituteCourseId);
	}

	@Override
	public int deleteInstituteCourse(InstituteCourse instituteCourse) {
		
		/*
		 * get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 * thread class not provided or number of collections in pool not provided. 
		 */
		Session session = sessionFactory.getCurrentSession();
		/*
		 * delete institute course in database
		 */
		try{
			session.delete(instituteCourse);		
			return 1;
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<InstituteCourse> getInstituteCourseListByCourseId(String courseId) {
		/*
		 * get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 * thread class not provided or number of collections in pool not provided. 
		 */
		Session session = sessionFactory.getCurrentSession();
		
		Query<InstituteCourse> query = session.createQuery("from InstituteCourse i where i.course.courseId=:cid");
		query.setParameter("cid", courseId);
		List<InstituteCourse> instituteCourses = query.getResultList();
		return instituteCourses;
	}

	@Override
	public List<InstituteCourse> getInstituteCourseListByInstituteId(int instituteId) {
		/*
		 * get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 * thread class not provided or number of collections in pool not provided. 
		 */
		Session session = sessionFactory.getCurrentSession();
		
		Query<InstituteCourse> query = session.createQuery("from InstituteCourse i where i.institute.instituteId=:id");
		query.setParameter("id", instituteId);
		List<InstituteCourse> instituteCourses = query.getResultList();
		return instituteCourses;
	}

}
