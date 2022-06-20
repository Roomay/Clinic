package com.dzqc.cloud.controller;

import com.dzqc.cloud.common.Message;
import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.entity.DoctorInfo;
import com.dzqc.cloud.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;


    /**
     * 获取医生名下的所有就诊预约
     * @return 该医生名下的所有就诊预约
     */
    @CrossOrigin
    @GetMapping("/consultation/selectByDoctor")
    public ResultObject selectByDoctorId(int doctorId) {
        return ResultObject.success(
                consultationService.selectByDoctorId(doctorId)
        );
    }
}
