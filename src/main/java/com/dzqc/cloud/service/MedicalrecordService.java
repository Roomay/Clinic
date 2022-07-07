package com.dzqc.cloud.service;

import com.dzqc.cloud.dao.ConsultationMapper;
import com.dzqc.cloud.dao.MedicalRecordMapper;
import com.dzqc.cloud.entity.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalrecordService {
    @Autowired
    private MedicalRecordMapper medicalRecordMapper;
    public int insertmedical(MedicalRecord medicalRecord) {

        medicalRecordMapper.insert(medicalRecord);
        return medicalRecord.getRecordId();
    }
}
