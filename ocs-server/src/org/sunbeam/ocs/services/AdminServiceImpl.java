package org.sunbeam.ocs.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sunbeam.ocs.dao.AdminDao;
import org.sunbeam.ocs.dao.CounsellingProcessPhaseDao;
import org.sunbeam.ocs.dao.CourseDao;
import org.sunbeam.ocs.dao.InstituteAllotmentDao;
import org.sunbeam.ocs.entities.Admin;
import org.sunbeam.ocs.entities.CounsellingProcessPhase;
import org.sunbeam.ocs.entities.Course;
import org.sunbeam.ocs.utils.AccountUtils;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	@Autowired
	CounsellingProcessPhaseDao counsellingProcessPhaseDao;
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	InstituteAllotmentDao instituteAllotmentDao;
	
	@Override
	public Serializable addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}

	@Override
	public Admin authenticateAdmin(Admin admin) {
		return adminDao.authenticateAdmin(admin);
	}

	@Override
	public int updateAdminPassword(Admin admin) {
		return adminDao.updateAdminPassword(admin);
	}

	@Override
	public int deleteAdmin(Admin admin) {
		return adminDao.deleteAdmin(admin);
	}

	@Override
	public int setCounsellingProcessPhase(CounsellingProcessPhase counsellingProcessPhase) {
		return counsellingProcessPhaseDao.setCounsellingProcessPhase(counsellingProcessPhase);
	}

	@Override
	public Serializable AddCourse(Course course) {
		return courseDao.addCourse(course);
	}

	@Override
	public CounsellingProcessPhase getCounsellingProcessPhase() {
		return counsellingProcessPhaseDao.getCounsellingProcessPhase();
	}

	@Override
	public int doInstituteAllocation(int round) {
		return instituteAllotmentDao.doInstituteAllocation(round);
	}

}
