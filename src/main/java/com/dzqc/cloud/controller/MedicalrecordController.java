package com.dzqc.cloud.controller;

import com.dzqc.cloud.common.Message;
import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.entity.Consultation;
import com.dzqc.cloud.entity.MedicalRecord;
import com.dzqc.cloud.entity.PatientInfo;
import com.dzqc.cloud.service.ClientService;
import com.dzqc.cloud.service.MedicalrecordService;
import com.dzqc.cloud.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;


@RestController
public class MedicalrecordController {

    @Autowired
    private MedicalrecordService medicalrecordService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private PatientService patientService;

    @RequestMapping( value="/medicalrecord/insert",method = RequestMethod.POST)
    public ResultObject insertrecord(@RequestBody MedicalRecord medicalRecord) {
        try {
            int x = medicalrecordService.insertmedical(medicalRecord);
            if (x== 0) {
                return ResultObject.error("插入失败");
            }
            else {
                return ResultObject.success(x);
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }

    /**
     * 根据姓名 + 年龄 + 症状表述
     * return 预测症状的可能的解决办法
     */
    @CrossOrigin
    @PostMapping("/medicalrecord/predictionCase")
    public ResultObject predictCase(int recordId) {
        try{
            MedicalRecord medicalRecord=medicalrecordService.selectByPrimaryKey(recordId);
            int patientId = medicalRecord.getPatientId();
            PatientInfo patient = patientService.findPatientById(patientId);
            String gender = "";
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String birthday = formatter.format(patient.getBirthday()).split("-")[0];
            String age = 2022 - Integer.parseInt(birthday) + "";
            String symptom = medicalRecord.getSymptom();
            if(medicalRecord.getGender().equals("0")) {
                gender = "女";
            } else {
                gender = "男";
            }
            String request = patientId + ";" + gender + "，" + age + "。" + symptom;
            String predictResult = clientService.sendMessageAndGetResultOfCasePrediction(request);
            if(predictResult.equals("")) {
                return ResultObject.error("症状结果预测失败");
            } else {
                return ResultObject.success(predictResult);
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }

    /**
     * 根据姓名 + 年龄 + 症状表述
     * return 3个预测的科室
     */
    @CrossOrigin
    @PostMapping("/medicalrecord/predictDepartment")
    public ResultObject predictDepartment(MedicalRecord medicalRecord) {
        try{
            int patientId = medicalRecord.getPatientId();
            PatientInfo patient = patientService.findPatientById(patientId);
            String gender = "";
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String birthday = formatter.format(patient.getBirthday()).split("-")[0];
            String age = 2022 - Integer.parseInt(birthday) + "";
            String symptom = medicalRecord.getSymptom();
            if(medicalRecord.getGender().equals("0")) {
                gender = "女";
            } else {
                gender = "男";
            }
            String request = patientId + ";" + gender + "，" + age + "。" + symptom;
            String predictResult = clientService.sendMessageAndGetResultOfClassification(request);
            if(predictResult.equals("")) {
                return ResultObject.error("预测科室失败");
            } else {
                return ResultObject.success(predictResult);
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }

    @PostMapping("/medicalrecord/selectByRecordId")
    public ResultObject selectByConsultationId(Integer recordId) {
        try {
            MedicalRecord medicalRecord = medicalrecordService.selectByPrimaryKey(recordId);
            if (medicalRecord==null) {
                return ResultObject.error("没有就诊记录");
            } else {
                return ResultObject.success(medicalRecord);
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PostMapping("/medicalrecord/selectByPatientName")
    public ResultObject selectByPatientName(String patientName) {
        try {
            List<MedicalRecord> consultationsFound = medicalrecordService.selectByPatientName(patientName);
            if (consultationsFound.isEmpty()) {
                return ResultObject.error("没有导诊记录");
            } else {
                return ResultObject.success(consultationsFound);
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }
}
