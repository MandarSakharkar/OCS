package org.sunbeam.ocs.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sunbeam.ocs.entities.Institute;
import org.sunbeam.ocs.entities.InstituteLogin;

@Repository
public class InstituteDaoImpl implements InstituteDao {

	@Autowired
	private SessionFactory factory;


	@Override
	public Serializable addInstitute(Institute institute) {

		Session session = factory.getCurrentSession();
		Serializable result = 0;
		try
		{
			result =  session.save(institute);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return result;

	}

	@Override
	public Institute getInstitute(int instituteId) {
		Session session = factory.getCurrentSession();
		return session.byId(Institute.class).load(instituteId);
		
	}

	@Override
	public Institute authenticateInstitute(InstituteLogin instituteLogin) {
		String hql = "from InstituteLogin i where i.instituteLoginId=:login_id and i.password=:password";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("login_id", instituteLogin.getInstituteLoginId());
		query.setParameter("password",instituteLogin.getPassword());

		try{
			instituteLogin = (InstituteLogin) query.getSingleResult();
		}
		catch(Exception ex)
		{
			instituteLogin=null;
			ex.printStackTrace();
		}
		if(instituteLogin!=null)
		{
			return getInstitute(instituteLogin.getInstituteId());
		}
		else
		{
			return null;
		}

	}

	@Override
	public int updateInstitutePassword(InstituteLogin instituteLogin) {
		String hql = "update StudentAccount set password=:password where instituteLoginId=:login_id";
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("login_id", instituteLogin.getInstituteLoginId());
		query.setParameter("password",instituteLogin.getPassword());

		int res = query.executeUpdate();
		tx.commit();
		return res;
	}

	@Override
	public int updateInstitute(Institute institute) {

		Session session = factory.getCurrentSession();
		session.update(institute);
		return 1;
	}

	@Override
	public Serializable addInstituteLogin(InstituteLogin instituteLogin) {
		Session session = factory.getCurrentSession();
		Serializable result =  session.save(instituteLogin);
		return result;
	}

}
