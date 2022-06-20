package com.dzqc.cloud.service;

import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.dao.ConsultationMapper;
import com.dzqc.cloud.entity.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultationService {
    @Autowired
    private ConsultationMapper consultationMapper;

    public Consultation selectByPrimaryKey(Integer consultationId) {
        return consultationMapper.selectByPrimaryKey(consultationId);
    }

    public List<Consultation> selectByDoctorId(int doctorId) {
        return consultationMapper.selectByDoctorId(doctorId);
    }
}
