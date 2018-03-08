package org.sunbeam.ocs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CounsellingProcessPhase {
	private int phaseId;
	private String phase;
	private int round;
	
	
	public CounsellingProcessPhase() {
	}
	
	public CounsellingProcessPhase(int phaseId, String phase,int round) {
		super();
		this.phaseId = phaseId;
		this.phase = phase;
		this.round = round;
	}
	
	@Id
	@Column(name="PHASE_ID")
	public int getPhaseId() {
		return phaseId;
	}
	public void setPhaseId(int phaseId) {
		this.phaseId = phaseId;
	}
	@Column(name="PHASE")
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}

	@Column(name="ROUND")
	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}
	
	
	
	
}
