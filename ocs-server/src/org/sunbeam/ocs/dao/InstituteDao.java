package org.sunbeam.ocs.dao;

import java.io.Serializable;

import org.sunbeam.ocs.entities.Institute;
import org.sunbeam.ocs.entities.InstituteLogin;

public interface InstituteDao {
	Serializable addInstitute(Institute institute);
	Institute getInstitute(int instituteId);
	Institute authenticateInstitute(InstituteLogin instituteLogin);
	int updateInstitutePassword(InstituteLogin instituteLogin);
	int updateInstitute(Institute institute);
	Serializable addInstituteLogin(InstituteLogin instituteLogin);
}
