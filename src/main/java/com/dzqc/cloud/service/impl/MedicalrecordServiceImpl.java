package com.dzqc.cloud.service.impl;

import com.dzqc.cloud.dao.MedicalRecordMapper;
import com.dzqc.cloud.entity.MedicalRecord;
import com.dzqc.cloud.service.MedicalrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicalrecordServiceImpl implements MedicalrecordService {
    @Autowired
    MedicalRecordMapper medicalRecordMapper;

    @Override
    public int insertmedical(MedicalRecord medicalRecord) {
        return medicalRecordMapper.insert(medicalRecord);
    }
}
