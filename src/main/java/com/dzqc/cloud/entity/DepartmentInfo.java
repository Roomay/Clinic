package com.dzqc.cloud.entity;

import java.io.Serializable;

public class DepartmentInfo implements Serializable {
    private Integer departmentId;

    private String departmentName;

    private Integer affliationId;

    private String introduction;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public DepartmentInfo(Integer departmentId, String departmentName, Integer affliationId, String introduction, Integer isDeleted) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.affliationId = affliationId;
        this.introduction = introduction;
        this.isDeleted = isDeleted;
    }

    public DepartmentInfo() {
        super();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Integer getAffliationId() {
        return affliationId;
    }

    public void setAffliationId(Integer affliationId) {
        this.affliationId = affliationId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

}