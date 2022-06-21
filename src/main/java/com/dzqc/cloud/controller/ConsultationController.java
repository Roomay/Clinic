package com.dzqc.cloud.controller;

import com.dzqc.cloud.common.Message;
import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.entity.Consultation;
import com.dzqc.cloud.entity.DoctorInfo;
import com.dzqc.cloud.service.ConsultationService;
import com.dzqc.cloud.service.MedicalrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsultationController {
    private static final int AVAILABLE = 0;
    private static final int UNAVAILABLE = 1;

    private static final int NOT_DELETED = 0;
    private static final int DELETED = 1;

    private static final int SUNDAY = 0;
    private static final int MONDAY = 1;
    private static final int TUESDAY = 2;
    private static final int WENDESDAY = 3;
    private static final int THURSDAY = 4;
    private static final int FRIDAY = 5;
    private static final int SATURDAY = 6;


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
     * 获取病人名下的所有就诊预约
     * @return 该病人名下的所有就诊预约
     */
    @GetMapping("/consultation/selectByPatientId")
    public ResultObject selectByPatientId(int patientId) {
        try {
            List<Consultation> consultationsFound = consultationService.selectByPatientId(patientId);
            if (consultationsFound.isEmpty()) {
                return ResultObject.error("没有就诊记录");
            } else {
                return ResultObject.success(consultationsFound);
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }

    /**
     * 预约一条坐诊
     * @return 预约成功的该条记录
     */

    @PostMapping("/consulation/appointment")
    public ResultObject appointment(@RequestBody Consultation consultation, Integer patientId, String patientName) {
        try {
            if (consultation.getAvailStatus()==UNAVAILABLE) {
                return ResultObject.error("该时间段已被预约");
            } else if (consultation.getIsDeleted()==DELETED) {
                return ResultObject.error("不存在该记录");
            } else {
                consultation.setAvailStatus(UNAVAILABLE);
                consultation.setPatientId(patientId);
                consultation.setPatientName(patientName);
                return ResultObject.success(consultation);
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }
}
