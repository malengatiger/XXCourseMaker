/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.util.CourseMakerData;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author aubreyM
 */
public class TraineeDTO implements Serializable, CourseMakerData, Comparable<TraineeDTO> {

	private static final long serialVersionUID = 1L;
	private Integer traineeID;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String cellphone, provinceName;
	private long dateRegistered, dateUpdated;
	private Integer gender;
	private List<GcmDeviceDTO> gcmDeviceList;
	private String iDNumber;
	private String address, password, cityName;
	private Integer cityID;
	private Integer companyID, provinceID;
	private int totalTasks, totalCompleted;
	private double percComplete, averageInstructorRating, averageTraineeRating;
	public double getAverageInstructorRating() {
		return averageInstructorRating;
	}

	public void setAverageInstructorRating(double averageInstructorRating) {
		this.averageInstructorRating = averageInstructorRating;
	}

	public double getAverageTraineeRating() {
		return averageTraineeRating;
	}

	public void setAverageTraineeRating(double averageTraineeRating) {
		this.averageTraineeRating = averageTraineeRating;
	}

	private long lastDate;
	public int getTotalTasks() {
		return totalTasks;
	}

	public void setTotalTasks(int totalTasks) {
		this.totalTasks = totalTasks;
	}

	public int getTotalCompleted() {
		return totalCompleted;
	}

	public void setTotalCompleted(int totalCompleted) {
		this.totalCompleted = totalCompleted;
	}

	public double getPercComplete() {
		if (totalTasks == 0) return 0;
		Double totComplete = Double.valueOf(totalCompleted);
		Double tasks = Double.valueOf(totalTasks);
		
		Double perc = (totComplete / tasks) * 100;
		percComplete = perc.doubleValue();
				
		return percComplete;
	}

	public void setPercComplete(double percComplete) {
		this.percComplete = percComplete;
	}

	public long getLastDate() {
		return lastDate;
	}

	public void setLastDate(long lastDate) {
		this.lastDate = lastDate;
	}

	private Integer institutionID;
	private Integer trainingClassID;
	private String trainingClassName;

	public String getFullName() {
		return this.firstName+ " " + this.lastName;
	}

	public Integer getTraineeID() {
		return traineeID;
	}

	public void setTraineeID(Integer traineeID) {
		this.traineeID = traineeID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public long getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(long dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getiDNumber() {
		return iDNumber;
	}

	public void setiDNumber(String iDNumber) {
		this.iDNumber = iDNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCityID() {
		return cityID;
	}

	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}

	public Integer getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}

	public Integer getInstitutionID() {
		return institutionID;
	}

	public void setInstitutionID(Integer institutionID) {
		this.institutionID = institutionID;
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

	public List<GcmDeviceDTO> getGcmDeviceList() {
		return gcmDeviceList;
	}

	public void setGcmDeviceList(List<GcmDeviceDTO> gcmDeviceList) {
		this.gcmDeviceList = gcmDeviceList;
	}


	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Integer getProvinceID() {
		return provinceID;
	}

	public void setProvinceID(Integer provinceID) {
		this.provinceID = provinceID;
	}

	public long getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(long dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@Override
	public int compareTo(TraineeDTO arg0) {
		
		String thisName = this.lastName + this.firstName;
		String anotherName = arg0.lastName + arg0.firstName;
		return thisName.compareTo(anotherName);
	}
}
