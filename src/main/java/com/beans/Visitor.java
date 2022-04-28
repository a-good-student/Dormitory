package com.beans;

import java.io.Serializable;

public class Visitor implements Serializable {
    private Integer ID;
    private String vname;
    private String vphone;
    private String dormId;
    private String dormName;
    private String visitTime;

    public Visitor() {}

    public Visitor(Integer ID, String vname, String vphone, String dormId, String dormName, String visitTime) {
        this.ID = ID;
        this.vname = vname;
        this.vphone = vphone;
        this.dormId = dormId;
        this.dormName = dormName;
        this.visitTime = visitTime;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVphone() {
        return vphone;
    }

    public void setVphone(String vphone) {
        this.vphone = vphone;
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

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }
}
