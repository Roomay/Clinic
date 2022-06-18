package com.dzqc.cloud.entity;

import java.io.Serializable;

public class AdminInfo implements Serializable {
    private Integer adminId;

    private String password;

    private String phone;

    private String validatecode;

    private static final long serialVersionUID = 1L;

    public AdminInfo(Integer adminId, String password, String phone, String validatecode) {
        this.adminId = adminId;
        this.password = password;
        this.phone = phone;
        this.validatecode = validatecode;
    }

    public AdminInfo() {
        super();
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getValidatecode() {
        return validatecode;
    }

    public void setValidatecode(String validatecode) {
        this.validatecode = validatecode == null ? null : validatecode.trim();
    }
}