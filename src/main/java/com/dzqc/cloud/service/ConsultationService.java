package com.dzqc.cloud.service;

import com.dzqc.cloud.dao.ConsultationMapper;
import com.dzqc.cloud.entity.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {
    @Autowired
    private ConsultationMapper consultationMapper;

    public List<Consultation> selectByDoctorId(int doctorId) {
        return consultationMapper.selectByDoctorId(doctorId);
    }

}
