package com.beans;

import java.io.Serializable;

public class DormHealth implements Serializable {
    private Integer ID;
    private String dormId;
    private String dormName;
    private String dormHealth;
    private String createTime;
    private String updateTime;

    public DormHealth() {}

    public DormHealth(Integer ID, String dormId, String dormName, String dormHealth, String createTime, String updateTime) {
        this.ID = ID;
        this.dormId = dormId;
        this.dormName = dormName;
        this.dormHealth = dormHealth;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public String getDormHealth() {
        return dormHealth;
    }

    public void setDormHealth(String dormHealth) {
        this.dormHealth = dormHealth;
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
