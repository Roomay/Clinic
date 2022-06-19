package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.PatientInfo;

public interface PatientInfoMapper {
    int deleteByPrimaryKey(Integer patientId);

    int insert(PatientInfo record);

    int insertSelective(PatientInfo record);

    PatientInfo selectByPrimaryKey(Integer patientId);

    int updateByPrimaryKeySelective(PatientInfo record);

    int updateByPrimaryKey(PatientInfo record);
}