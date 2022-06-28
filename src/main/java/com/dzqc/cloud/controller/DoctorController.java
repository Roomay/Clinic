package com.dzqc.cloud.controller;

import com.dzqc.cloud.common.Message;
import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.entity.DepartmentInfo;
import com.dzqc.cloud.entity.DoctorInfo;
import com.dzqc.cloud.service.DoctorinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DoctorController {

    @Autowired
    private DoctorinfoService doctorinfoService;


    /**
     * 按科室Id查找医生
     * @param departmentId
     * @return
     */
    @CrossOrigin
    @GetMapping("doctor/selectByDepartmentId")
    public ResultObject selectByDepartmentId(Integer departmentId) {
        try {
            List<DoctorInfo> doctorsfound = doctorinfoService.selectByDepartmentId(departmentId);
            if (doctorsfound == null) {
                return ResultObject.error("没有找到对应医生");
            } else {
                return ResultObject.success(doctorsfound);
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }
}
