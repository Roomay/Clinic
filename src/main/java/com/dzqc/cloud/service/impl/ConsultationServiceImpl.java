package com.dzqc.cloud.service.impl;

import com.dzqc.cloud.dao.ConsultationMapper;
import com.dzqc.cloud.entity.Consultation;
import com.dzqc.cloud.entity.DoctorInfo;
import com.dzqc.cloud.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationServiceImpl implements ConsultationService {
    @Autowired
    ConsultationMapper consultationMapper;

    @Override
    public List<Consultation> selectByDoctorId(int doctorId) {
        return consultationMapper.selectByDoctorId(doctorId);
    }
}
