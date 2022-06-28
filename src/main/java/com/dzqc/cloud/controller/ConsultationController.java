package com.dzqc.cloud.controller;

import com.dzqc.cloud.common.Message;
import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.entity.Consultation;
import com.dzqc.cloud.entity.DepartmentInfo;
import com.dzqc.cloud.entity.DoctorInfo;
import com.dzqc.cloud.entity.PatientInfo;
import com.dzqc.cloud.service.ConsultationService;
import com.dzqc.cloud.service.MedicalrecordService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    private static final int TIMESLOT_BEGIN = 0;
    private static final int TIMESLOT_END = 20;

    @Autowired
    private ConsultationService consultationService;

    /**
     * 增加一条坐诊信息 Junru
     * @return 成功增加的坐诊信息
     */
    @CrossOrigin
    @PostMapping("/consultation/insertAConsultation")
    public ResultObject insertAConsultation(Consultation record) {
        if (record == null || record.getDoctorId() == null || record.getDoctorName() == null) {
            return ResultObject.error("添加坐诊信息失败，医生信息不能为空");
        }
        if (record.getDaySlot() < SUNDAY || record.getDaySlot() > SATURDAY) {
            return ResultObject.error("添加坐诊信息失败，日期信息越界");
        }
        if (record.getTimeSlot() < TIMESLOT_BEGIN || record.getTimeSlot() > TIMESLOT_END) {
            return ResultObject.error("添加坐诊信息失败，时间信息越界");
        }
        try {
            record.setConsultationId(null);
            record.setIsDeleted(NOT_DELETED);
            int inserted = consultationService.insertConsultation(record);
            if (inserted == 1) {
                return ResultObject.success("添加坐诊信息成功");
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
    @CrossOrigin
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
     * @return 该病人名下的所有就诊预约 根据session
     */
    @CrossOrigin
    @PostMapping("/consultation/selectByPatientName")
    public ResultObject selectByPatientName(String PatientName) {
        try {
            List<Consultation> consultationsFound = consultationService.selectByPatientName(PatientName);
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
    @CrossOrigin
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
     * 预约一条坐诊
     * @return 预约成功的该条记录
     */
    @CrossOrigin
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
     * 增加一条坐诊信息 Chongyue
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

    /**
     * 批量删除电子病历
     * @param ids
     * @return 反馈信息
     */
    @CrossOrigin
    @RequestMapping("/consultation/batchDelete")
    public ResultObject batchDelete(Integer [] ids){
        try {
            int deleted = this.consultationService.batchDelete(ids);
            if (deleted > 0) {
                return ResultObject.success("删除电子病历成功");
            } else {
                return ResultObject.error("提供的id均不存在");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultObject.error("删除电子病历失败");
        }
    }

    /**
     * 根据日期返回当日空余的TimeSlot
     * @return 根据TimeSlot分类的坐诊信息列表
     */
    @CrossOrigin
    @GetMapping("/consultation/selectByDate")
    public ResultObject selectByDateDepartment(Integer daySlot, DepartmentInfo departmentInfo) {
        try {
            List<List<Consultation>> list = new ArrayList<>();
            int departmentId = departmentInfo.getDepartmentId();
            for (int i = TIMESLOT_BEGIN; i <= TIMESLOT_END; i++) {
                list.add(consultationService.selectByTimeDepartment(daySlot, i, departmentId));
            }
            return ResultObject.success(list);
        } catch (Exception e) {
            return ResultObject.error("查询当天坐诊失败");
        }
    }

    /**
     * 部分修改一条坐诊信息(根据consultationId定位)
     * @return 反馈信息
     */
    @CrossOrigin
    @PostMapping("/consultation/updateByPrimaryKeySelective")
    public ResultObject updateByPrimaryKeySelective(Consultation consultation) {
        try {
            int u = consultationService.updateByPrimaryKeySelective(consultation);
            if (u == 0) {
                return ResultObject.error("部分更新失败");
            } else {
                return ResultObject.success("部分更新成功");
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }

    /**
     * 完全替换一条坐诊信息(根据consultationId定位)
     * @return 反馈信息
     */
    @CrossOrigin
    @PostMapping("/consultation/updateByPrimaryKey")
    public ResultObject updateByPrimaryKey(Consultation consultation) {
        try {
            int u = consultationService.updateByPrimaryKey(consultation);
            if (u == 0) {
                return ResultObject.error("部分更新失败");
            } else {
                return ResultObject.success("部分更新成功");
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }


}
