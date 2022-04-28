package com.beans;

import java.io.Serializable;

public class Dorm implements Serializable {
    private Integer ID;
    private String dormId;
    private String dormName;
    private Integer bedNum;
    private Integer bedUse;
    private String admin;

    public Dorm() {}

    public Dorm(Integer ID, String dormId, String dormName, Integer bedNum, Integer bedUse, String admin) {
        this.ID = ID;
        this.dormId = dormId;
        this.dormName = dormName;
        this.bedNum = bedNum;
        this.bedUse = bedUse;
        this.admin = admin;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDormId() {
        return dormId;
    }

    public void setDormId(String dormId) {
        this.dormId = dormId;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    public Integer getBedNum() {
        return bedNum;
    }

    public void setBedNum(Integer bedNum) {
        this.bedNum = bedNum;
    }

    public Integer getBedUse() {
        return bedUse;
    }

    public void setBedUse(Integer bedUse) {
        this.bedUse = bedUse;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
