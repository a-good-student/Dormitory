package com.beans;

import java.util.Date;

public class Repair {
    private Integer ID;
    private String dormId;
    private String dormName;
    private String repairMan;
    private String repairName;
    private String repairTime;
    private String updateTime;

    public Repair() {}

    public Repair(Integer ID, String dormId, String dormName, String repairMan, String repairName, String repairTime, String updateTime) {
        this.ID = ID;
        this.dormId = dormId;
        this.dormName = dormName;
        this.repairMan = repairMan;
        this.repairName = repairName;
        this.repairTime = repairTime;
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

    public String getRepairMan() {
        return repairMan;
    }

    public void setRepairMan(String repairMan) {
        this.repairMan = repairMan;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public String getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(String repairTime) {
        this.repairTime = repairTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
