package com.dzqc.cloud.service;

import com.dzqc.cloud.entity.Consultation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsultationService {
    public List<Consultation> selectByDoctorId(int doctorId);
}
