package com.dzqc.cloud.controller;

import com.dzqc.cloud.common.Message;
import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.entity.Consultation;
import com.dzqc.cloud.entity.DoctorInfo;
import com.dzqc.cloud.entity.PatientInfo;
import com.dzqc.cloud.service.ConsultationService;
import com.dzqc.cloud.service.MedicalrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    private static final int TIME_BEGIN = 0;
    private static final int TIMESLOT_END = 20;

    @Autowired
    private ConsultationService consultationService;

    /**
     * 增加一条坐诊信息
     * @return 成功增加的坐诊信息
     */
    @PostMapping("/consultation/insertAConsultation")
    public ResultObject insertAConsultation(Consultation record) {
        if (record.getDoctorId() == null || record.getDoctorName() == null) {
            return ResultObject.error("添加坐诊信息失败，医生信息不能为空");
        }
        if (record.getDaySlot() < SUNDAY || record.getDaySlot() > SATURDAY) {
            return ResultObject.error("添加坐诊信息失败，日期信息越界");
        }
        if (record.getTimeSlot() < TIME_BEGIN || record.getTimeSlot() > TIMESLOT_END) {
            return ResultObject.error("添加坐诊信息失败，时间信息越界");
        }
        try {
            record.setConsultationId(null);
            record.setIsDeleted(NOT_DELETED);
            int inserted = consultationService.insertConsultation(record);
            if (inserted == 1) {
                return ResultObject.success();
            } else {
                return ResultObject.error("添加坐诊信息失败");
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }


    /**
     * 获取医生名下的所有就诊预约
     * @return 该医生名下的所有就诊预约
     */
    @PostMapping("/consultation/selectByDoctor")
    public ResultObject selectByDoctorId(Integer doctorId) {
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
    @PostMapping("/consultation/selectByPatientId")
    public ResultObject selectByPatientId(Integer patientId) {
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
     * 预约一条坐诊 Junru
     * @return 预约成功的该条记录
     */

    @PostMapping("/consulation/appointment")
    public ResultObject appointment(Consultation consultation, PatientInfo patientInfo) {
        try {
            if (consultation == null) {
                return ResultObject.error("不存在该记录");
            } else if (consultation.getAvailStatus()==UNAVAILABLE) {
                return ResultObject.error("该时间段已被预约");
            } else if (consultation.getIsDeleted()==DELETED) {
                return ResultObject.error("不存在该记录");
            } else {
                consultation.setAvailStatus(UNAVAILABLE);
                consultation.setPatientId(patientInfo.getPatientId());
                consultation.setPatientName(patientInfo.getPatientName());
                return ResultObject.success(consultation);
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }



    /**
     * 插入一条坐诊 Chongyue
     * @return 反馈信息
     */
    @CrossOrigin
    @PostMapping("/consulation/insertappointment")
    public ResultObject insertappointment(@RequestBody Consultation consultation) {
        try {
            int c = consultationService.insertConsultation(consultation);
            if (c == 0) {
                return ResultObject.error("插入失败");
            }
            else {
                return ResultObject.success("插入成功");
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }
}
