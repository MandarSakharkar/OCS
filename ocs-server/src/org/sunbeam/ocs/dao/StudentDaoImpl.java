package org.sunbeam.ocs.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.sunbeam.ocs.entities.Preference;
import org.sunbeam.ocs.entities.Student;
import org.sunbeam.ocs.entities.StudentAccount;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public Serializable addStudent(Student student) {

		//adding student to database

		/*get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 *thread class not provided or number of collections in pool not provided. 
		 */
		Session session = factory.getCurrentSession();

		

		/*
		 * add student to database
		 */
		Serializable result = 0;
		try
		{
			result = session.save(student);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int updateStudent(Student student) {
		//updating student in database

		/*
		 * get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 * thread class not provided or number of collections in pool not provided. 
		 */
		Session session = factory.getCurrentSession();

		//begin the transaction over session

		

		/*
		 * update student in database
		 */
		int result = 0;
		try
		{
			session.update(student);
			result = 1;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Student getStudent(long formNumber) {
		//hql query to select record with matching formNumber,password pair
		String hql = "from Student c where c.studentAccount.formNumber=:form_number";

		/*get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 *thread class not provided or number of collections in pool not provided. 
		 */
		Session session = factory.getCurrentSession();

		
		//convert the hql query to native queries
		Query<Student> query = session.createQuery(hql,Student.class);

		//setting parameter value of form number and password with the credentials given by user
		query.setParameter("form_number", formNumber);

		Student student = null;
		try
		{
			/*
			 *query.getSingleResult returns result object or throws javax.persistence.NoResultException: No entity found for query
			 *this block is to handle if result not found i.e candidate with given form number not present
			 */
			student = (Student) query.getSingleResult();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		return student;
	}

	@Override
	@Transactional
	public List<Student> getStudentsList() {
		//hql query to get List Full Details of students
		String hql = /*"select"
				+" sa.formNumber,"
				+" sa.fullName,"
				+" sa.contactNumber,"
				+" sa.eMailId,"
				+" s.adharNumber,"
				+" s.panNumber,"
				+" s.gender,"
				+" s.category,"
				+" s.dateOfBirth,"
				+" s.nationality,"
				+" s.address,"
				+" s.pincode,"
				+" s.eCatRollNumber,"
				+" s.eCatRank,"
				+" s.degree,"
				+" s.degreePercentage,"
				+" s.photo,"
				+" s.isValidated"
				+*/" from Student s";

		/*get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 *thread class not provided or number of collections in pool not provided. 
		 */
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Student> studentList  = session.createQuery(hql).getResultList();

		
		return studentList;
	}

	@Override
	public int deleteStudent(Student student) {
		//deleting student in database

		/*
		 * get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 * thread class not provided or number of collections in pool not provided. 
		 */
		Session session = factory.getCurrentSession();

		//begin the transaction over session

		Transaction tx = session.beginTransaction();


		/*
		 * delete student in database
		 */
		int result = 0;
		try
		{
			session.delete(student);
			tx.commit();
			result = 1;
		} 
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}
}
