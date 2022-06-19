package com.dzqc.cloud.common;

import com.dzqc.cloud.entity.MedicalRecord;
import com.dzqc.cloud.service.MedicalrecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.dzqc.cloud.dao")
public class test  {

    @Autowired
    private MedicalrecordService medicalrecordService;

    @Test
    public void test(){
        MedicalRecord medicalRecord=new MedicalRecord();
        medicalRecord.setPatientId(223110);
        int s=medicalrecordService.insertmedical(medicalRecord);
        System.out.println(s);

    }

}
