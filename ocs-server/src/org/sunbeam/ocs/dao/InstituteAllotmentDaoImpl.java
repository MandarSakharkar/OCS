package org.sunbeam.ocs.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sunbeam.ocs.entities.InstituteAllotment;

@Repository
public class InstituteAllotmentDaoImpl implements InstituteAllotmentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<InstituteAllotment> getInstituteAllotmentListByInstituteCourseId(int instituteCourseId) {
		/*get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 *thread class not provided or number of collections in pool not provided. 
		 */
		Session session = sessionFactory.getCurrentSession();
		String hql = "from InstituteAllotment i where i.instituteCourse.instituteCourseId=:icid";
		Query query  = session.createQuery(hql);
		query.setParameter("icid", instituteCourseId);
		
		
		return query.getResultList();
	}

	@Override
	public InstituteAllotment getInstituteAllotmentByFormNumber(long formNumber) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from InstituteAllotment i where i.studentAccount.formNumber=:fn";
		Query query  = session.createQuery(hql);
		query.setParameter("fn",formNumber);
		InstituteAllotment instituteAllotment = null;
		try
		{
			instituteAllotment = (InstituteAllotment) query.getSingleResult();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return instituteAllotment;
	}

	@Override
	public List<InstituteAllotment> getCompleteInstituteAllotmentList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from InstituteAllotment i ";
		session.beginTransaction();
		return session.createQuery(hql).list();
	}

	@Override
	public int doInstituteAllocation(int round) {
		Session session = sessionFactory.getCurrentSession();
		session.doWork(new Work() {
			
			@Override
			public void execute(Connection connection) throws SQLException {
				CallableStatement callableStatement = connection.prepareCall("CALL proc_allotment(?)");
				callableStatement.setInt(1, round);
				callableStatement.execute();
			}
		});
		return 1;
	}
	
	public int updateInstituteAllotment(InstituteAllotment instituteAllotment)
	{
		Session session = sessionFactory.getCurrentSession();
		System.out.println(instituteAllotment.getAllotmentId());
		try
		{
			session.update(instituteAllotment);
			return 1;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}		
	}	
}
