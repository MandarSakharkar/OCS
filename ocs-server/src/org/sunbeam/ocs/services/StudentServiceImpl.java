package org.sunbeam.ocs.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sunbeam.ocs.dao.CounsellingProcessPhaseDao;
import org.sunbeam.ocs.dao.InstituteAllotmentDao;
import org.sunbeam.ocs.dao.PreferenceDao;
import org.sunbeam.ocs.dao.StudentAccountDao;
import org.sunbeam.ocs.dao.StudentDao;
import org.sunbeam.ocs.entities.CounsellingProcessPhase;
import org.sunbeam.ocs.entities.InstituteAllotment;
import org.sunbeam.ocs.entities.Preference;
import org.sunbeam.ocs.entities.Student;
import org.sunbeam.ocs.entities.StudentAccount;
import org.sunbeam.ocs.utils.AccountUtils;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentAccountDao studentAccountDao;
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private PreferenceDao preferenceDao;
	
	@Autowired
	CounsellingProcessPhaseDao counsellingProcessPhaseDao;
	
	@Autowired
	InstituteAllotmentDao instituteAllotmentDao;
	
	public StudentServiceImpl() {
		
	}

	//StudentAccount Service (Account related)
	
	@Override
	public Serializable addStudentAccount(StudentAccount studentAccount){
		return studentAccountDao.addStudentAccount(studentAccount);	
	}

	@Override
	public StudentAccount authenticateStudent(StudentAccount studentAccount) {
		return studentAccountDao.authenticateStudent(studentAccount);
	}

	@Override
	public int changeStudentPassword(StudentAccount studentAccount) {
		return studentAccountDao.updateStudentPassword(studentAccount);
	}

	
	// StudentAccount Detail Services
	
	@Override
	public Serializable addStudent(Student student) {
		
		return studentDao.addStudent(student);
		
	}

	@Override
	public int updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	@Override
	public Student getStudent(long formNumber) {
		
		return studentDao.getStudent(formNumber);
	}

	@Override
	public Serializable addStudentPreference(Preference preference) {
		return preferenceDao.addPreference(preference);
	}

	@Override
	public int updateStudentPreference(Preference preference) {
		return preferenceDao.updatePreference(preference);
	}

	@Override
	public int deleteStudentPreference(Preference preference) {
		return preferenceDao.deleteStudentPreference(preference);
	}

	@Override
	public Preference getStudentPreferenceDetail(long preferenceId) {
		return preferenceDao.getPreferenceDetail(preferenceId);
	}

	@Override
	public CounsellingProcessPhase getCounsellingProcessPhase() {
		return counsellingProcessPhaseDao.getCounsellingProcessPhase();
	}

	@Override
	public List<Preference> getPreferencesByFormNumber(long formNumber) {
		return preferenceDao.getPreferencesByFormNumber(formNumber);
	}

	@Override
	public Serializable savePreference(Preference preference) {
		return preferenceDao.savePreference(preference);
	}

	@Override
	public InstituteAllotment getInstituteAllotmentByFormNumber(long formNumber) {
		return instituteAllotmentDao.getInstituteAllotmentByFormNumber(formNumber);
	}
	@Override
	public StudentAccount getStudentAccount(StudentAccount studentAccount)
	{
		return studentAccountDao.getStudentAccount(studentAccount);
	}
	
}
