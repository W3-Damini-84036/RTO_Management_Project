package com.sunbeaminfo.project.entity;

import java.io.Serializable;

public class Admin implements Serializable {

    private int admin_id;
    private String name;
    private String email;
    private String password;
    private String mobile;

    public Admin() {
    }

    public Admin(int admin_id, String name, String email, String password, String mobile) {
        this.admin_id = admin_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
    }

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Admin(String name, String email, String password) {
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}


