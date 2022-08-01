package com.dzqc.cloud.controller;

import com.dzqc.cloud.common.Message;
import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.entity.DepartmentInfo;
import com.dzqc.cloud.entity.DoctorInfo;
import com.dzqc.cloud.service.DoctorinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class DoctorController {

    private static final int NOT_DELETED = 0;
    private static final int DELETED = 1;

    @Autowired
    private DoctorinfoService doctorinfoService;


    /**
     * 按科室Id查找医生
     * @param departmentId
     * @return 医生信息
     */
    @CrossOrigin
    @GetMapping("doctor/selectByDepartmentId")
    public ResultObject selectByDepartmentId(Integer departmentId) {
        try {
            List<DoctorInfo> doctorsFound = doctorinfoService.selectByDepartmentId(departmentId);
            if (doctorsFound == null) {
                return ResultObject.error("没有找到对应医生");
            } else {
                return ResultObject.success(doctorsFound);
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }


    /**
     * 获取所有的科室
     * @return 所有的科室信息
     */
    @GetMapping("/doctor/list")
    public ResultObject list(){
        try {
            List<DoctorInfo> doctorInfos = doctorinfoService.selectAll();
            if (doctorInfos == null) {
                return ResultObject.error("获取医生信息失败");
            } else {
                return ResultObject.success(doctorInfos);
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }

    /**
     * 按科室名字查找医生
     * @param departmentName
     * @return 医生信息
     */
    @CrossOrigin
    @GetMapping("doctor/selectByDepartmentName")
    public ResultObject selectByDepartmentName(String departmentName) {
        try {
            List<DoctorInfo> doctorsFound = doctorinfoService.selectByDepartmentName(departmentName);
            if (doctorsFound == null) {
                return ResultObject.error("没有找到对应医生");
            } else {
                return ResultObject.success(doctorsFound);
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }

    /**
     * 添加医生
     * @param record
     * @return 反馈信息
     */
    @PostMapping("/doctor/insertADoctor")
    public ResultObject insertADoctor(DoctorInfo record) {
        if (record == null || record.getDoctorName() == null) {
            return ResultObject.error("添加医生失败，医生名不能为空");
        }
        try {
            record.setDoctorId(null);
            record.setIsDeleted(NOT_DELETED);
            int inserted = doctorinfoService.insertADoctor(record);
            if (inserted == 1) {
                return ResultObject.success("添加医生成功");
            } else {
                return ResultObject.error("添加医生失败");
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return 反馈信息
     */
    @CrossOrigin
    @RequestMapping("/doctor/batchDelete")
    public ResultObject batchDelete(Integer [] ids){
        try {
            int deleted = this.doctorinfoService.batchDelete(ids);
            if (deleted > 0) {
                return ResultObject.success("删除医生成功");
            } else {
                return ResultObject.error("提供的id均不存在");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultObject.error("删除医生失败");
        }
    }

    /**
     * 完全替换一条医生信息(根据doctorId定位)
     * @param record
     * @return 反馈信息
     */
    @CrossOrigin
    @PostMapping("/doctor/updateByPrimaryKey")
    public ResultObject updateByPrimaryKey(DoctorInfo record) {
        try {
            int u = doctorinfoService.updateByPrimaryKey(record);
            if (u == 0) {
                return ResultObject.error("替换失败");
            } else {
                return ResultObject.success("替换成功");
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }

    /**
     * 部分修改一条医生信息(根据doctorId定位)
     * @param doctorInfo
     * @return 反馈信息
     */
    @CrossOrigin
    @PostMapping("/doctor/updateByPrimaryKeySelective")
    public ResultObject updateByPrimaryKeySelective(DoctorInfo doctorInfo) {
        try {
            int u = doctorinfoService.updateByPrimaryKeySelective(doctorInfo);
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
     * login
     * @return
     */
    @CrossOrigin
    @RequestMapping( "/doctor/selectBydoctorname")
    public ResultObject selectBydoctorname(String username,String password) {
        try {
            DoctorInfo patientInfo = this.doctorinfoService.selectBydoctorname(username);
            //
            if (patientInfo==null) {
                return ResultObject.error("未注册");
            }
            else if (patientInfo.getPassword().equals(password)) {
                return ResultObject.success(patientInfo);
            }
            else if (!patientInfo.getPassword().equals(password)){
                return ResultObject.error("密码错"+patientInfo.getPassword());
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
        return null;
    }

}
