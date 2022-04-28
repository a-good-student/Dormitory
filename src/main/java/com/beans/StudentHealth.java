package com.beans;

import java.io.Serializable;

public class StudentHealth implements Serializable {
    private Integer ID;
    private String sno;
    private String sname;
    private String StudentHealth;
    private String classId;
    private String dormId;
    private String createTime;
    private String updateTime;

    public StudentHealth() {}

    public StudentHealth(Integer ID, String sno, String sname, String studentHealth, String classId, String dormId, String createTime, String updateTime) {
        this.ID = ID;
        this.sno = sno;
        this.sname = sname;
        StudentHealth = studentHealth;
        this.classId = classId;
        this.dormId = dormId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getStudentHealth() {
        return StudentHealth;
    }

    public void setStudentHealth(String studentHealth) {
        StudentHealth = studentHealth;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getDormId() {
        return dormId;
    }

    public void setDormId(String dormId) {
        this.dormId = dormId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
