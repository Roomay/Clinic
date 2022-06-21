package com.dzqc.cloud.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Consultation implements Serializable {
    private Integer consultationId;

    private Integer doctorId;

    private String doctorName;

    private Integer daySlot;

    private Integer timeSlot;

    private Integer availStatus;

    private String comment;

    private BigDecimal charge;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public Consultation(Integer consultationId, Integer doctorId, String doctorName, Integer daySlot, Integer timeSlot, Integer availStatus, String comment, BigDecimal charge, Integer isDeleted) {
        this.consultationId = consultationId;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.daySlot = daySlot;
        this.timeSlot = timeSlot;
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

    public Integer getDaySlot() {
        return daySlot;
    }

    public void setDaySlot(Integer daySlot) {
        this.daySlot = daySlot;
    }

    public Integer getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Integer timeSlot) {
        this.timeSlot = timeSlot;
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