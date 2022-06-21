package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.Consultation;
import com.dzqc.cloud.entity.DoctorInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConsultationMapper {
    int deleteByPrimaryKey(Integer consultationId);

    int insert(Consultation record);

    int insertSelective(Consultation record);

    Consultation selectByPrimaryKey(Integer consultationId);

    int updateByPrimaryKeySelective(Consultation record);

    int updateByPrimaryKey(Consultation record);

    List<Consultation> selectByDoctorId(Integer doctorId);

    List<Consultation> selectByPatientId(Integer patientId);
}