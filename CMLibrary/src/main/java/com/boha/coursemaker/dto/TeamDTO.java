package com.boha.coursemaker.dto;

import java.io.Serializable;
import java.util.List;

public class TeamDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer teamID;
    private String teamName, trainingClassName;
    private long dateRegistered;
    private Integer trainingClassID;
    private List<TeamMemberDTO> teamMemberList;
	public Integer getTeamID() {
		return teamID;
	}
	public void setTeamID(Integer teamID) {
		this.teamID = teamID;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public long getDateRegistered() {
		return dateRegistered;
	}
	public void setDateRegistered(long dateRegistered) {
		this.dateRegistered = dateRegistered;
	}
	public Integer getTrainingClassID() {
		return trainingClassID;
	}
	public void setTrainingClassID(Integer trainingClassID) {
		this.trainingClassID = trainingClassID;
	}
	public List<TeamMemberDTO> getTeamMemberList() {
		return teamMemberList;
	}
	public void setTeamMemberList(List<TeamMemberDTO> teamMemberList) {
		this.teamMemberList = teamMemberList;
	}
	public String getTrainingClassName() {
		return trainingClassName;
	}
	public void setTrainingClassName(String trainingClassName) {
		this.trainingClassName = trainingClassName;
	}
}
