package com.dzqc.cloud.entity;

import java.io.Serializable;
import java.util.Date;

public class DoctorInfo implements Serializable {
    private Integer doctorId;

    private String doctorName;

    private String password;

    private String cid;

    private String phone;

    private String validatecode;

    private Integer departmentId;

    private Integer titleId;

    private String comment;

    private String headimg;

    private Integer availState;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public DoctorInfo(Integer doctorId, String doctorName, String password, String cid, String phone, String validatecode, Integer departmentId, Integer titleId, String comment, String headimg, Integer availState, Date createTime, Date updateTime) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.password = password;
        this.cid = cid;
        this.phone = phone;
        this.validatecode = validatecode;
        this.departmentId = departmentId;
        this.titleId = titleId;
        this.comment = comment;
        this.headimg = headimg;
        this.availState = availState;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public DoctorInfo() {
        super();
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
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

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public Integer getAvailState() {
        return availState;
    }

    public void setAvailState(Integer availState) {
        this.availState = availState;
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