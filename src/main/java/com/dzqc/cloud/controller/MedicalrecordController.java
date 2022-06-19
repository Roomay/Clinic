package com.dzqc.cloud.controller;

import com.dzqc.cloud.common.Message;
import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.entity.MedicalRecord;
import com.dzqc.cloud.entity.PatientInfo;
import com.dzqc.cloud.service.MedicalrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
@Controller
public class MedicalRecordController {
=======
@RestController
public class MedicalrecordController {

>>>>>>> 0c1bd94b53d56df24f6560d2c7ab278040496551
    @Autowired
    private MedicalrecordService medicalrecordService;

    @RequestMapping( value="/medicalrecord/insert",method = RequestMethod.POST)
    public ResultObject insertrecord(@RequestBody MedicalRecord medicalRecord) {
        try {
            int x = medicalrecordService.insertmedical(medicalRecord);
            if (x==0) {
                return ResultObject.error("未注册");
            }
            else {
                return ResultObject.success(x);
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }
}
