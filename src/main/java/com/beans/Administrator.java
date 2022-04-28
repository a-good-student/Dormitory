package com.beans;

import java.io.Serializable;

public class Administrator implements Serializable {
    private Integer ID;
    private String adminName;
    private String name;
    private String adminPhone;
    private String rank;
    private String adminTime;

    public Administrator() {}

    public Administrator(Integer ID, String adminName, String name, String adminPhone, String rank, String adminTime) {
        this.ID = ID;
        this.adminName = adminName;
        this.name = name;
        this.adminPhone = adminPhone;
        this.rank = rank;
        this.adminTime = adminTime;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAdminTime() {
        return adminTime;
    }

    public void setAdminTime(String adminTime) {
        this.adminTime = adminTime;
    }
}
