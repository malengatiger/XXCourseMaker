package com.boha.coursemaker.dto;

import java.io.Serializable;

public class TrainingClassEventDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer trainingClassEventID;

    private long eventID;
    private String eventName;
    private String description;
    private long dateRegistered;
    private String location;
    private long startDate;
    private long endDate;
    private Integer trainingClassID, trainingClassCourseID;
    
	public Integer getTrainingClassEventID() {
		return trainingClassEventID;
	}
	public void setTrainingClassEventID(Integer trainingClassEventID) {
		this.trainingClassEventID = trainingClassEventID;
	}
	public long getEventID() {
		return eventID;
	}
	public void setEventID(long eventID) {
		this.eventID = eventID;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getDateRegistered() {
		return dateRegistered;
	}
	public void setDateRegistered(long dateRegistered) {
		this.dateRegistered = dateRegistered;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getStartDate() {
		return startDate;
	}
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}
	public long getEndDate() {
		return endDate;
	}
	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}
	public Integer getTrainingClassID() {
		return trainingClassID;
	}
	public void setTrainingClassID(Integer trainingClassID) {
		this.trainingClassID = trainingClassID;
	}
	public Integer getTrainingClassCourseID() {
		return trainingClassCourseID;
	}
	public void setTrainingClassCourseID(Integer trainingClassCourseID) {
		this.trainingClassCourseID = trainingClassCourseID;
	}
}
