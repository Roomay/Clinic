package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.MedicalRecord;

public interface MedicalRecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(MedicalRecord record);

    int insertSelective(MedicalRecord record);

    MedicalRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(MedicalRecord record);

    int updateByPrimaryKey(MedicalRecord record);
}