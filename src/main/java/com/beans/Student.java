package com.beans;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer ID;
    private String Sno;
    private String Sname;
    private String Ssex;
    private String Sage;
    private String Sphone;
    private String ClassId;
    private String ClassName;
    private String Dormitory;

    public Student() {}

    public Student(Integer ID, String sno, String sname, String ssex, String sage, String sphone, String classId, String className, String dormitory) {
        this.ID = ID;
        Sno = sno;
        Sname = sname;
        Ssex = ssex;
        Sage = sage;
        Sphone = sphone;
        ClassId = classId;
        ClassName = className;
        Dormitory = dormitory;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public String getSage() {
        return Sage;
    }

    public void setSage(String sage) {
        Sage = sage;
    }

    public String getSphone() {
        return Sphone;
    }

    public void setSphone(String sphone) {
        Sphone = sphone;
    }

    public String getClassId() {
        return ClassId;
    }

    public void setClassId(String classId) {
        ClassId = classId;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getDormitory() {
        return Dormitory;
    }

    public void setDormitory(String dormitory) {
        Dormitory = dormitory;
    }
}
