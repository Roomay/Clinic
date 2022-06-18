package com.dzqc.cloud.entity;

import java.io.Serializable;
import java.util.Date;

public class MedicalRecord implements Serializable {
    private Integer recordId;

    private Integer patientId;

    private String patientName;

    private String gender;

    private String symptom;

    private String drugsused;

    private Integer doctorId;

    private String doctorName;

    private String preconsultation;

    private Integer reportId;

    private String diagnosis;

    private String prescription;

    private Integer departmentId;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public MedicalRecord(Integer recordId, Integer patientId, String patientName, String gender, String symptom, String drugsused, Integer doctorId, String doctorName, String preconsultation, Integer reportId, String diagnosis, String prescription, Integer departmentId, Date createTime, Date updateTime, Integer status) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.gender = gender;
        this.symptom = symptom;
        this.drugsused = drugsused;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.preconsultation = preconsultation;
        this.reportId = reportId;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.departmentId = departmentId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public MedicalRecord() {
        super();
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom == null ? null : symptom.trim();
    }

    public String getDrugsused() {
        return drugsused;
    }

    public void setDrugsused(String drugsused) {
        this.drugsused = drugsused == null ? null : drugsused.trim();
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

    public String getPreconsultation() {
        return preconsultation;
    }

    public void setPreconsultation(String preconsultation) {
        this.preconsultation = preconsultation == null ? null : preconsultation.trim();
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis == null ? null : diagnosis.trim();
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription == null ? null : prescription.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}