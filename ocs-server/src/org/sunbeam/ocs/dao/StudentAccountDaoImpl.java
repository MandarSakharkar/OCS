package org.sunbeam.ocs.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sunbeam.ocs.entities.StudentAccount;

@Repository
public class StudentAccountDaoImpl implements StudentAccountDao {

	@Autowired
	private SessionFactory factory;
	
	public StudentAccountDaoImpl() {
	}

	@Override
	public Serializable addStudentAccount(StudentAccount studentAccount) {
		//adding student account to database
		
		/*get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		*thread class not provided or number of collections in pool not provided. 
		*/
		Session session = factory.getCurrentSession();
		
		
		/*
		 * add student account to database and return the formNumber 
		 */
		Serializable result = 0;
		try
		{
			result = session.save(studentAccount);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public StudentAccount authenticateStudent(StudentAccount studentAccount) {
		//hql query to select record with matching formNumber,password pair
		String hql = "from StudentAccount s where s.formNumber=:form_number and s.password=:password";
		
		/*get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		*thread class not provided or number of collections in pool not provided. 
		*/
		Session session = factory.getCurrentSession();
		
		
		//convert the hql query to native queries
		Query<StudentAccount> query = session.createQuery(hql,StudentAccount.class);
		
		//setting parameter value of form number and password with the credentials given by user
		query.setParameter("form_number", studentAccount.getFormNumber());
		query.setParameter("password",studentAccount.getPassword());
		
		try
		{
			/*
			 *query.getSingleResult returns result object or throws javax.persistence.NoResultException: No entity found for query
			 *this block is to handle if result not found i.e student login credentials are not correct.
			 */
			studentAccount = (StudentAccount) query.getSingleResult();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			studentAccount=null;
		}
		return studentAccount;
	}

	@Override
	public int updateStudentPassword(StudentAccount studentAccount) {
		//hql query to update password of candidate
		String hql = "update StudentAccount set password=:password where formNumber=:form_number";
		
		/*get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		*thread class not provided or number of collections in pool not provided. 
		*/
		Session session = factory.getCurrentSession();
		
		
		/*
		 * convert the hql query to native queries don't provide type for update and delete queries else 
		 *java.lang.IllegalArgumentException: Update/delete queries cannot be typed will be thrown
		 */
		Query query = session.createQuery(hql);
		
		//setting parameter value of form number and password with the credentials given by user
		query.setParameter("form_number", studentAccount.getFormNumber());
		query.setParameter("password",studentAccount.getPassword());
		
		/*
		 * get and return result. 
		 * if updated will return 1. i.e number of rows
		 */
		
		
		int result = 0;
		try{
			result=query.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public StudentAccount getStudentAccount(StudentAccount studentAccount)
	{
		//hql query to select record with matching formNumber,password pair
		String hql = "from StudentAccount sa where sa.formNumber=:form_number or sa.emailId=:email";

		/*get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 *thread class not provided or number of collections in pool not provided. 
		 */
		Session session = factory.getCurrentSession();

		
		//convert the hql query to native queries
		Query<StudentAccount> query = session.createQuery(hql,StudentAccount.class);

		//setting parameter value of form number and password with the credentials given by user
		query.setParameter("form_number", studentAccount.getFormNumber());
		query.setParameter("email",studentAccount.getEmailId());

		try
		{
			/*
			 *query.getSingleResult returns result object or throws javax.persistence.NoResultException: No entity found for query
			 *this block is to handle if result not found i.e candidate with given form number not present
			 */
			studentAccount = (StudentAccount) query.getSingleResult();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		return studentAccount;
	}
}
