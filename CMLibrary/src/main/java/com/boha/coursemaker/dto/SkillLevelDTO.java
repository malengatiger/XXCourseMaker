package com.boha.coursemaker.dto;

/**
 * Created by aubreyM on 2014/08/02.
 */
public class SkillLevelDTO {
    private int skillLevelID, level;
    private String skillLevelName;

    public int getSkillLevelID() {
        return skillLevelID;
    }

    public void setSkillLevelID(int skillLevelID) {
        this.skillLevelID = skillLevelID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSkillLevelName() {
        return skillLevelName;
    }

    public void setSkillLevelName(String skillLevelName) {
        this.skillLevelName = skillLevelName;
    }

}
