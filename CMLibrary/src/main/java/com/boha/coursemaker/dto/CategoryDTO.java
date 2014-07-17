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
public class CategoryDTO  implements Serializable, CourseMakerData {
	   
		private static final long serialVersionUID = 1L;


private Integer categoryID;
    
    private String categoryName;
    private List<CourseDTO> courseList;
    private Integer companyID;
    private Long localID;
    private long syncDate;
    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

   
    
   

	public List<CourseDTO> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<CourseDTO> courseList) {
		this.courseList = courseList;
	}

	public Integer getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}

	

	public long getSyncDate() {
		return syncDate;
	}

	public void setSyncDate(long syncDate) {
		this.syncDate = syncDate;
	}

	public Long getLocalID() {
		return localID;
	}

	public void setLocalID(Long localID) {
		this.localID = localID;
	}

	
    
   
    
}
