package com.beans;

import java.io.Serializable;

public class Classes implements Serializable {
    private Integer ID;
    private String classId;
    private String className;
    private String teacher;

    public Classes() {}

    public Classes(Integer ID, String classId, String className, String teacher) {
        this.ID = ID;
        this.classId = classId;
        this.className = className;
        this.teacher = teacher;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
