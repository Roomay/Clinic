package com.dzqc.cloud.controller;

import com.dzqc.cloud.common.Message;
import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.entity.Consultation;
import com.dzqc.cloud.entity.DoctorInfo;
import com.dzqc.cloud.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;


    /**
     * 获取医生名下的所有就诊预约
     * @return 该医生名下的所有就诊预约
     */
    @GetMapping("/consultation/selectByDoctor")
    public ResultObject selectByDoctorId(int doctorId) {
        try {
            List<Consultation> consultationsFound = consultationService.selectByDoctorId(doctorId);
            if (consultationsFound.isEmpty()) {
                return ResultObject.error("没有坐诊记录");
            } else {
                return ResultObject.success(consultationsFound);
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }

    /**
     * 预约该条坐诊
     * @return 预约是否成功
     */
//    @GetMapping("/consultation/selectByPatientId")
//    public ResultObject selectByPatientId(int patientId) {
//        try {
//            List<>
//        }
//    }
}
