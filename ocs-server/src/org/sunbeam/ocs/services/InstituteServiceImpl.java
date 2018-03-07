package org.sunbeam.ocs.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sunbeam.ocs.dao.CounsellingProcessPhaseDao;
import org.sunbeam.ocs.dao.CourseDao;
import org.sunbeam.ocs.dao.InstituteAllotmentDao;
import org.sunbeam.ocs.dao.InstituteCourseDao;
import org.sunbeam.ocs.dao.InstituteDao;
import org.sunbeam.ocs.dao.StudentDao;
import org.sunbeam.ocs.entities.CounsellingProcessPhase;
import org.sunbeam.ocs.entities.Course;
import org.sunbeam.ocs.entities.Institute;
import org.sunbeam.ocs.entities.InstituteAllotment;
import org.sunbeam.ocs.entities.InstituteCourse;
import org.sunbeam.ocs.entities.InstituteLogin;
import org.sunbeam.ocs.entities.Student;
import org.sunbeam.ocs.utils.AccountUtils;

@Service
@Transactional
public class InstituteServiceImpl implements InstituteService {

	@Autowired
	InstituteDao instituteDao;
	
	@Autowired
	InstituteCourseDao instituteCourseDao;
	
	@Autowired 
	CourseDao courseDao;
	
	@Autowired
	CounsellingProcessPhaseDao counsellingProcessPhaseDao;
	
	@Autowired
	InstituteAllotmentDao instituteAllotmentDao;
	
	@Override
	public Serializable registerInstitute(Institute institute) {
		
		return instituteDao.addInstitute(institute);
	}

	@Override
	@Transactional
	public Institute authenticateInstitute(InstituteLogin instituteLogin) {
		instituteLogin.setPassword(AccountUtils.getMD5Password(instituteLogin.getPassword()));
		return instituteDao.authenticateInstitute(instituteLogin);
	}

	@Override
	public boolean changeInstitutePassword(InstituteLogin instituteLogin) {
		instituteLogin.setPassword(AccountUtils.getMD5Password(instituteLogin.getPassword()));
		return instituteDao.updateInstitutePassword(instituteLogin)==1;
	}

	@Override
	public boolean updateInstituteDetails(Institute institute) {
		return instituteDao.updateInstitute(institute)==1;
	}

	@Override
	public Serializable addInstituteAccount(InstituteLogin instituteLogin) {
		instituteLogin.setPassword(AccountUtils.getMD5Password(instituteLogin.getPassword()));
		return instituteDao.addInstituteLogin(instituteLogin);
	}

	@Override
	@Transactional
	public Serializable addInstituteCourse(InstituteCourse instituteCourse) {
		return instituteCourseDao.addInstituteCourse(instituteCourse);
	}

	@Override
	public int updateInstituteCourse(InstituteCourse instituteCourse) {
		return instituteCourseDao.updateInstituteCourse(instituteCourse);
	}

	@Override
	public InstituteCourse getInstituteCourse(int instituteCourseId) {
		return instituteCourseDao.getInstituteCourse(instituteCourseId);
	}

	@Override
	public int deleteInstituteCourse(InstituteCourse instituteCourse) {
		return instituteCourseDao.deleteInstituteCourse(instituteCourse);
	}

	@Override
	public List<Course> getCourseList() {		
		return courseDao.getCourseList();
	}

	@Override
	public List<InstituteCourse> getInstituteCourseByCourseId(String courseId) {
		return instituteCourseDao.getInstituteCourseListByCourseId(courseId);
	}

	@Override
	public List<InstituteCourse> getInstituteCourseByInstituteId(int instituteId) {
		return instituteCourseDao.getInstituteCourseListByInstituteId(instituteId);
	}

	@Override
	public CounsellingProcessPhase getCounsellingProcessPhase() {
		return counsellingProcessPhaseDao.getCounsellingProcessPhase();
	}

	@Autowired
	StudentDao studentDao;
	
	
	
	@Override
	public int ValidateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	@Override
	public Student getStudentDetails(long formNumber) {
		return studentDao.getStudent(formNumber);
	}

	@Override
	public List<InstituteAllotment> getInstituteAllotmentListByInstituteCourseId(int instituteCourseId) {
		return instituteAllotmentDao.getInstituteAllotmentListByInstituteCourseId(instituteCourseId);
	}
	
	@Override
	public int updateInstituteAllotment(InstituteAllotment instituteAllotment)
	{
		return instituteAllotmentDao.updateInstituteAllotment(instituteAllotment);
	}
	
	@Override
	public InstituteAllotment getInstituteAllotmentByFormNumber(long formNumber) {
		return instituteAllotmentDao.getInstituteAllotmentByFormNumber(formNumber);
	}
}
