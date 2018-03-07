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
import org.sunbeam.ocs.entities.Preference;


@Repository
public class PreferenceDaoImpl implements PreferenceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable addPreference(Preference preference) {

		/*
		 * get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 * thread class not provided or number of collections in pool not provided. 
		 */
		Session session = sessionFactory.getCurrentSession();

		/*
		 * add preference to database
		 */
		Serializable result = session.save(preference);

		return result;
	}

	public Serializable savePreference(Preference preference) {

		/*
		 * get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 * thread class not provided or number of collections in pool not provided. 
		 */
		Session session = sessionFactory.getCurrentSession();

		/*
		 * add preference to database
		 */
		
		try {
			session.saveOrUpdate(preference);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return 0;
		}

		return 1;
	}


	@Override
	public int updatePreference(Preference preference) {
		/*get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 *thread class not provided or number of collections in pool not provided. 
		 */
		Session session = sessionFactory.getCurrentSession();
		/*
		 * update preference in database
		 */
		try{
			session.update(preference);		
			return 1;

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public Preference getPreferenceDetail(long preferenceId) {

		Session session = sessionFactory.getCurrentSession();

		//return the preference detail by preferenceId
		return session.byId(Preference.class).load(preferenceId);
	}

	@Override
	public int deleteStudentPreference(Preference preference) {
		/*
		 * get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 * thread class not provided or number of collections in pool not provided. 
		 */
		Session session = sessionFactory.getCurrentSession();
		/*
		 * delete preference in database
		 */
		try{
			session.delete(preference);	
			return 1;

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Preference> getPreferencesByFormNumber(long formNumber) {
		/*
		 * get current hibernate session. will throw exception if in hibernate-persitence.xml, 
		 * thread class not provided or number of collections in pool not provided. 
		 */
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Preference p where p.studentAccount.formNumber=:fn";


		Query q = session.createQuery(hql);
		q.setParameter("fn", formNumber);
		List<Preference> preferences = null;

		//to handle the empty results
		try {
			preferences = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preferences;
	}

}
