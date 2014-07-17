/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.util.CourseMakerData;

import java.io.Serializable;



/**
 *
 * @author aubreyM
 */
public class LessonScheduleDTO  implements Serializable, CourseMakerData {
	   
		private static final long serialVersionUID = 1L;

private Integer lessonScheduleID;
    
    private long scheduleDate;
    
    private long endDate;
    
    private Integer lessonID;
    
    private Integer trainingClassID;   
    
  

    public Integer getLessonScheduleID() {
        return lessonScheduleID;
    }

    public void setLessonScheduleID(Integer lessonScheduleID) {
        this.lessonScheduleID = lessonScheduleID;
    }

    public long getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(long scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public Integer getLessonID() {
        return lessonID;
    }

    public void setLessonID(Integer lessonID) {
        this.lessonID = lessonID;
    }

    public Integer getTrainingClassID() {
        return trainingClassID;
    }

    public void setTrainingClassID(Integer trainingClassID) {
        this.trainingClassID = trainingClassID;
    }
}
