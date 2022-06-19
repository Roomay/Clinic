package com.dzqc.cloud.service.impl;

import com.dzqc.cloud.dao.PatientInfoMapper;
import com.dzqc.cloud.entity.PatientInfo;
import com.dzqc.cloud.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientInfoMapper patientInfoMapper;
    @Override
    public PatientInfo login(String username) {
        return patientInfoMapper.selectByusername(username);
    }
}
