package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.PatientInfo;
import com.dzqc.cloud.entity.PatientInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PatientInfoMapper {
    int countByExample(PatientInfoExample example);

    int deleteByExample(PatientInfoExample example);

    int deleteByPrimaryKey(Integer patientId);

    int insert(PatientInfo record);

    int insertSelective(PatientInfo record);

    List<PatientInfo> selectByExample(PatientInfoExample example);

    PatientInfo selectByPrimaryKey(Integer patientId);

    int updateByExampleSelective(@Param("record") PatientInfo record, @Param("example") PatientInfoExample example);

    int updateByExample(@Param("record") PatientInfo record, @Param("example") PatientInfoExample example);

    int updateByPrimaryKeySelective(PatientInfo record);

    int updateByPrimaryKey(PatientInfo record);
}