package com.boha.coursemaker.dto;

import java.io.Serializable;

public class GcmDeviceDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer gcmDeviceID;
    private String registrationID;
    private String manufacturer;
    private String model;
    private String product;
    private Integer messageCount;
    private long dateRegistered;
    private String serialNumber;
    private Integer reportUserID;
    private Integer traineeID;
    private Integer instructorID;
    private Integer authorID;
    private Integer administratorID;
	public Integer getGcmDeviceID() {
		return gcmDeviceID;
	}
	public void setGcmDeviceID(Integer gcmDeviceID) {
		this.gcmDeviceID = gcmDeviceID;
	}
	public String getRegistrationID() {
		return registrationID;
	}
	public void setRegistrationID(String registrationID) {
		this.registrationID = registrationID;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Integer getMessageCount() {
		return messageCount;
	}
	public void setMessageCount(Integer messageCount) {
		this.messageCount = messageCount;
	}
	public long getDateRegistered() {
		return dateRegistered;
	}
	public void setDateRegistered(long dateRegistered) {
		this.dateRegistered = dateRegistered;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Integer getReportUserID() {
		return reportUserID;
	}
	public void setReportUserID(Integer reportUserID) {
		this.reportUserID = reportUserID;
	}
	public Integer getTraineeID() {
		return traineeID;
	}
	public void setTraineeID(Integer traineeID) {
		this.traineeID = traineeID;
	}
	public Integer getInstructorID() {
		return instructorID;
	}
	public void setInstructorID(Integer instructorID) {
		this.instructorID = instructorID;
	}
	public Integer getAuthorID() {
		return authorID;
	}
	public void setAuthorID(Integer authorID) {
		this.authorID = authorID;
	}
	public Integer getAdministratorID() {
		return administratorID;
	}
	public void setAdministratorID(Integer administratorID) {
		this.administratorID = administratorID;
	}
}
