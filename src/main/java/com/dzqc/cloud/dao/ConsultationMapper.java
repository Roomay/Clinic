package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.Consultation;
import com.dzqc.cloud.entity.DoctorInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Mapper
public interface ConsultationMapper {
    int deleteByPrimaryKey(Integer consultationId);

    int insert(Consultation record);

    int insertSelective(@RequestBody Consultation record);

    Consultation  selectByPrimaryKey(Integer consultationId);

    int updateByPrimaryKeySelective(Consultation record);

    int updateByPrimaryKey(Consultation record);

    List<Consultation> selectByDoctorId(Integer doctorId);

    List<Consultation> selectByPatientId(Integer patientId);

    List<Consultation> selectByPatientName(String patientName);

    int softDeleteByPrimaryKey(Integer consultationId);

    List<Consultation> selectByDoctorName(String doctorName);

    List<Consultation> selectByTimeDoctor(@Param("dates") String dates, @Param("doctorName") String doctorName);

    List<Consultation> selectByTimeDepartmentId(@Param("dates") Date dates, @Param("timeSlot") Integer timeSlot, @Param("departmentId") Integer departmentId);
}