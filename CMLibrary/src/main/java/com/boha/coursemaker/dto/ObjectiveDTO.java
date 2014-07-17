package com.boha.coursemaker.dto;

public class ObjectiveDTO {

	private Integer objectiveID;
	private String objectiveName, description;
	private Integer courseID;

	public Integer getObjectiveID() {
		return objectiveID;
	}

	public void setObjectiveID(Integer objectiveID) {
		this.objectiveID = objectiveID;
	}

	public String getObjectiveName() {
		return objectiveName;
	}

	public void setObjectiveName(String objectiveName) {
		this.objectiveName = objectiveName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCourseID() {
		return courseID;
	}

	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}
}
