package org.sunbeam.ocs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sunbeam.ocs.entities.CounsellingProcessPhase;

@Repository
public class CounsellingProcessPhaseDaoImpl implements CounsellingProcessPhaseDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CounsellingProcessPhase getCounsellingProcessPhase() {
		/*get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		*thread class not provided or number of collections in pool not provided. 
		*/
		Session session = sessionFactory.getCurrentSession();
		
		//begin the transaction over session
		String hql = "from CounsellingProcessPhase"; 
		/*
		 * convert the hql query to native queries don't provide type for update and delete queries else 
		 *java.lang.IllegalArgumentException: Update/delete queries cannot be typed will be thrown
		 */
		return (CounsellingProcessPhase) session.createQuery(hql).getSingleResult();		
	}
	public int setCounsellingProcessPhase(CounsellingProcessPhase counsellingProcessPhase)
	{
		Session session = sessionFactory.getCurrentSession();
		session.update(counsellingProcessPhase);
		return 1;
	}
}
