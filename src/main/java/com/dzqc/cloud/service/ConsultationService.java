package com.dzqc.cloud.service;

import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.dao.ConsultationMapper;
import com.dzqc.cloud.entity.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ConsultationService {
    @Autowired
    private ConsultationMapper consultationMapper;

    public  List<Consultation>  selectByConsultationId(Integer consultationId) {
        return consultationMapper.selectByPrimaryKey(consultationId);
    }

    public List<Consultation> selectByDoctorId(Integer doctorId) {
        return consultationMapper.selectByDoctorId(doctorId);
    }

    public List<Consultation> selectByPatientId(Integer patientId) {
        return consultationMapper.selectByPatientId(patientId);
    }

    public List<Consultation> selectByPatientName(String patientName) {
        return consultationMapper.selectByPatientName(patientName);
    }

    public int insertConsultation(Consultation consultation) {
        return consultationMapper.insert(consultation);
    }

    public int batchDelete(Integer[] ids) {
        int count = 0;
        for (Integer id : ids) {
            count += consultationMapper.softDeleteByPrimaryKey(id);
        }
        return count;
    }

    public List<Consultation> selectByTimeDepartment(Integer daySlot , Integer timeSlot, Integer departmentId) {
        return consultationMapper.selectByTimeDepartmentId(daySlot, timeSlot, departmentId);
    }

    public int updateByPrimaryKeySelective(Consultation record) {
        return consultationMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Consultation record) {
        return consultationMapper.updateByPrimaryKey(record);
    }
}
