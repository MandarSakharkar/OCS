package org.sunbeam.ocs.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sunbeam.ocs.entities.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Serializable addAdmin(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		return session.save(admin);
	}

	@Override
	public Admin authenticateAdmin(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Admin a where a.adminId=:aid and a.password=:pw");
		q.setParameter("aid",admin.getAdminId());
		q.setParameter("pw",admin.getPassword());
		
		try{
			admin = (Admin) q.getSingleResult();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			admin = null;
		}
		
		return admin;
	}

	@Override
	public int updateAdminPassword(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		session.update(admin);
		return 1;
	}

	@Override
	public int deleteAdmin(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(admin);
		return 1;
	}

}
