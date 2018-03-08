package org.sunbeam.ocs.dao;

import java.io.Serializable;
import java.util.List;

import org.sunbeam.ocs.entities.Preference;

public interface PreferenceDao {
	Serializable addPreference(Preference preference);
	int updatePreference(Preference preference);
	Preference getPreferenceDetail(long preferenceId);
	int deleteStudentPreference(Preference preference);
	
	Serializable savePreference(Preference preference);
	
	List<Preference> getPreferencesByFormNumber(long formNumber); 
}
