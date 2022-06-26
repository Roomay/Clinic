package com.dzqc.cloud.service;

import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.dao.ConsultationMapper;
import com.dzqc.cloud.entity.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultationService {
    @Autowired
    private ConsultationMapper consultationMapper;

    public Consultation selectByConsultationId(Integer consultationId) {
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

    public void batchDelete(Integer[] ids) {
        for (Integer id : ids) {
            consultationMapper.softDeleteByPrimaryKey(id);
        }
    }

    public List<Consultation> selectByTimeDepartment(Integer timeSlot, Integer departmentId) {
        return consultationMapper.selectByTimeDepartmentId(timeSlot, departmentId);
    }
}
