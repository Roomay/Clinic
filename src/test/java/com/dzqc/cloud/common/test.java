package com.dzqc.cloud.common;

import com.dzqc.cloud.entity.Consultation;
import com.dzqc.cloud.entity.MedicalRecord;
import com.dzqc.cloud.service.ConsultationService;
import com.dzqc.cloud.service.MedicalrecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.dzqc.cloud.dao")
public class test  {

    @Autowired
    private ConsultationService consultationService;

    @Test
    public void test(){
        Consultation consultation=new Consultation();
        consultation.setDoctorId(1);
        consultation.setDoctorName("1");
        consultation.setPatientName("1");
        consultation.setCharge(BigDecimal.valueOf(1.0));
        Integer s = new Integer(1);
//        System.out.println(consultation);
        List<Consultation> ss=consultationService.selectByPatientId(s);
        System.out.println(ss);

//        System.out.println(consultation);
        s =consultationService.insertConsultation(consultation);
        System.out.println(s);

    }

}
