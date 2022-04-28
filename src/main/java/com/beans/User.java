package com.beans;

import java.io.Serializable;

public class User implements Serializable {
    private String adminName;
    private String password;
    private String name;

    public User() {
    }

    public User(String adminName, String password, String name) {
        this.adminName = adminName;
        this.password = password;
        this.name = name;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
