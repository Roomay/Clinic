package com.dzqc.cloud.entity;

import java.io.Serializable;
import java.util.Date;

public class PatientInfo implements Serializable {
    private Integer patientId;

    private String patientName;

    private String password;

    private String cid;

    private String phone;

    private String validatecode;

    private Date birthday;

    private String gender;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public PatientInfo(Integer patientId, String patientName, String password, String cid, String phone, String validatecode, Date birthday, String gender, Date createTime, Date updateTime) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.password = password;
        this.cid = cid;
        this.phone = phone;
        this.validatecode = validatecode;
        this.birthday = birthday;
        this.gender = gender;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PatientInfo() {
        super();
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}