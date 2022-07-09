package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.Consultation;
import com.dzqc.cloud.entity.MedicalRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MedicalRecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(MedicalRecord record);

    int insertSelective(MedicalRecord record);

    MedicalRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(MedicalRecord record);

    int updateByPrimaryKey(MedicalRecord record);

    List<MedicalRecord> selectByPatientName(String patientName);
}