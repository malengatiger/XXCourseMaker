package com.boha.coursemaker.dto;

import java.io.Serializable;

public class InstructorClassDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer instructorClassID;
    private long dateRegistered, startDate, endDate;
    
    private Integer instructorID;
    private String trainingClassName;
    private long calendarID;
    private Integer trainingClassID;
    private int totalTasks, totalComplete;
	private double percComplete;
	public Integer getInstructorClassID() {
		return instructorClassID;
	}
	public void setInstructorClassID(Integer instructorClassID) {
		this.instructorClassID = instructorClassID;
	}
	public long getDateRegistered() {
		return dateRegistered;
	}
	public void setDateRegistered(long dateRegistered) {
		this.dateRegistered = dateRegistered;
	}
	public Integer getInstructorID() {
		return instructorID;
	}
	public void setInstructorID(Integer instructorID) {
		this.instructorID = instructorID;
	}
	public Integer getTrainingClassID() {
		return trainingClassID;
	}
	public void setTrainingClassID(Integer trainingClassID) {
		this.trainingClassID = trainingClassID;
	}
	public String getTrainingClassName() {
		return trainingClassName;
	}
	public void setTrainingClassName(String trainingClassName) {
		this.trainingClassName = trainingClassName;
	}
	public long getCalendarID() {
		return calendarID;
	}
	public void setCalendarID(long calendarID) {
		this.calendarID = calendarID;
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
	public int getTotalTasks() {
		return totalTasks;
	}
	public void setTotalTasks(int totalTasks) {
		this.totalTasks = totalTasks;
	}
	public int getTotalComplete() {
		return totalComplete;
	}
	public void setTotalComplete(int totalComplete) {
		this.totalComplete = totalComplete;
	}
	public double getPercComplete() {
		return percComplete;
	}
	public void setPercComplete(double percComplete) {
		this.percComplete = percComplete;
	}
}
