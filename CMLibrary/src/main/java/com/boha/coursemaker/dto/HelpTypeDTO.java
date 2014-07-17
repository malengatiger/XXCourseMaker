package com.boha.coursemaker.dto;

import com.boha.coursemaker.util.CourseMakerData;

import java.io.Serializable;

public class HelpTypeDTO implements Serializable, CourseMakerData, LookupInterface {

	private static final long serialVersionUID = 1L;

	private Integer helpTypeID, companyID;
	private String helpTypeName;

	public Integer getHelpTypeID() {
		return helpTypeID;
	}

	public void setHelpTypeID(Integer helpTypeID) {
		this.helpTypeID = helpTypeID;
	}

	public String getHelpTypeName() {
		return helpTypeName;
	}

	public void setHelpTypeName(String helpTypeName) {
		this.helpTypeName = helpTypeName;
	}

	public Integer getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}
}
