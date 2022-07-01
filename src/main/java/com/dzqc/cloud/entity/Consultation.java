package com.dzqc.cloud.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Consultation implements Serializable {
    private Integer consultationId;

    private Integer doctorId;

    private String doctorName;

    private Integer departmentId;

    private Date dates;

    private Integer timeSlot;

    private Integer patientId;

    private String patientName;

    private Integer availStatus;

    private String comment;

    private BigDecimal charge;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public Consultation(Integer consultationId, Integer doctorId, String doctorName, Integer departmentId, Date dates, Integer timeSlot, Integer patientId, String patientName, Integer availStatus, String comment, BigDecimal charge, Integer isDeleted) {
        this.consultationId = consultationId;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.departmentId = departmentId;
        this.dates = dates;
        this.timeSlot = timeSlot;
        this.patientId = patientId;
        this.patientName = patientName;
        this.availStatus = availStatus;
        this.comment = comment;
        this.charge = charge;
        this.isDeleted = isDeleted;
    }

    public Consultation() {
        super();
    }

    public Integer getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
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

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Integer getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Integer timeSlot) {
        this.timeSlot = timeSlot;
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

    public Integer getAvailStatus() {
        return availStatus;
    }

    public void setAvailStatus(Integer availStatus) {
        this.availStatus = availStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}