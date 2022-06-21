package com.dzqc.cloud.entity;

import java.io.Serializable;
import java.util.Date;

public class CheckReport implements Serializable {
    private Integer reportId;

    private Integer patientId;

    private Integer consultationId;

    private String inspectionitem;

    private String attachment;

    private String comment;

    private Date checkTime;

    private Integer departmentId;

    private String description;

    private String conclusion;

    private Integer issueDoctorId;

    private Integer conductDoctorId;

    private Date createTime;

    private Date updateTime;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public CheckReport(Integer reportId, Integer patientId, Integer consultationId, String inspectionitem, String attachment, String comment, Date checkTime, Integer departmentId, String description, String conclusion, Integer issueDoctorId, Integer conductDoctorId, Date createTime, Date updateTime, Integer isDeleted) {
        this.reportId = reportId;
        this.patientId = patientId;
        this.consultationId = consultationId;
        this.inspectionitem = inspectionitem;
        this.attachment = attachment;
        this.comment = comment;
        this.checkTime = checkTime;
        this.departmentId = departmentId;
        this.description = description;
        this.conclusion = conclusion;
        this.issueDoctorId = issueDoctorId;
        this.conductDoctorId = conductDoctorId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDeleted = isDeleted;
    }

    public CheckReport() {
        super();
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
    }

    public String getInspectionitem() {
        return inspectionitem;
    }

    public void setInspectionitem(String inspectionitem) {
        this.inspectionitem = inspectionitem == null ? null : inspectionitem.trim();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion == null ? null : conclusion.trim();
    }

    public Integer getIssueDoctorId() {
        return issueDoctorId;
    }

    public void setIssueDoctorId(Integer issueDoctorId) {
        this.issueDoctorId = issueDoctorId;
    }

    public Integer getConductDoctorId() {
        return conductDoctorId;
    }

    public void setConductDoctorId(Integer conductDoctorId) {
        this.conductDoctorId = conductDoctorId;
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}