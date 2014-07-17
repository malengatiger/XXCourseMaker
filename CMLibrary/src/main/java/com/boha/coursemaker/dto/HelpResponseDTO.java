package com.boha.coursemaker.dto;

import java.io.Serializable;

/**
 * 
 * @author aubreyM
 */
public class HelpResponseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	 private Integer helpResponseID;
	    private String message;
	    private long dateResponse;
	    private Integer scheduleMeeting;
	    private Integer problemSorted, instructorID;
	    private long meetingDate;
	    private HelpRequestDTO helpRequest;
	public Integer getHelpResponseID() {
		return helpResponseID;
	}

	public void setHelpResponseID(Integer helpResponseID) {
		this.helpResponseID = helpResponseID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getDateResponse() {
		return dateResponse;
	}

	public void setDateResponse(long dateResponse) {
		this.dateResponse = dateResponse;
	}

	public Integer getScheduleMeeting() {
		return scheduleMeeting;
	}

	public void setScheduleMeeting(Integer scheduleMeeting) {
		this.scheduleMeeting = scheduleMeeting;
	}

	public Integer getProblemSorted() {
		return problemSorted;
	}

	public void setProblemSorted(Integer problemSorted) {
		this.problemSorted = problemSorted;
	}

	public long getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(long meetingDate) {
		this.meetingDate = meetingDate;
	}

	public HelpRequestDTO getHelpRequest() {
		return helpRequest;
	}

	public void setHelpRequest(HelpRequestDTO helpRequest) {
		this.helpRequest = helpRequest;
	}

	public Integer getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(Integer instructorID) {
		this.instructorID = instructorID;
	}
}
