package com.dzqc.cloud.service;

import com.dzqc.cloud.entity.Consultation;
import com.dzqc.cloud.entity.DoctorInfo;

import java.util.List;

public interface ConsultationService {
    public List<Consultation> selectByDoctorId(int doctorId);
}
