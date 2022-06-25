package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.Consultation;
import com.dzqc.cloud.entity.DoctorInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ConsultationMapper {
    int deleteByPrimaryKey(Integer consultationId);

    int insert(Consultation record);

    int insertSelective(@RequestBody Consultation record);

    Consultation selectByPrimaryKey(Integer consultationId);

    int updateByPrimaryKeySelective(Consultation record);

    int updateByPrimaryKey(Consultation record);

    List<Consultation> selectByDoctorId(Integer doctorId);

    List<Consultation> selectByPatientId(Integer patientId);

    void softDeleteByPrimaryKey(Integer consultationId);
}