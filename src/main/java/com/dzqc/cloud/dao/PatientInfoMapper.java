package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.PatientInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatientInfoMapper {
    int deleteByPrimaryKey(Integer patientId);

    int insert(PatientInfo record);

    int insertSelective(PatientInfo record);

    PatientInfo selectByPrimaryKey(Integer patientId);

    int updateByPrimaryKeySelective(PatientInfo record);

    int updateByPrimaryKey(PatientInfo record);

    PatientInfo selectByUsername(String patientName);
}