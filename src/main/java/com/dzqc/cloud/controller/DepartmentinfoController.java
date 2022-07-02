package com.dzqc.cloud.controller;

import com.dzqc.cloud.common.Message;
import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.entity.Consultation;
import com.dzqc.cloud.entity.DepartmentInfo;
import com.dzqc.cloud.service.DepartmentinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentinfoController {

    private static final int NOT_DELETED = 0;
    private static final int DELETED = 1;

      @Autowired
      private DepartmentinfoService departmentinfoService;


      /**
       * 获取所有的科室
       * @return 所有的科室信息
       */
      @GetMapping("/departmentinfo/list")
      public ResultObject list(){
          try {
              List<DepartmentInfo> allDepartments = departmentinfoService.selectAll();
              if (allDepartments == null) {
                  return ResultObject.error("获取科室信息失败");
              } else {
                  return ResultObject.success(allDepartments);
              }
          } catch (Exception e) {
              return ResultObject.error(Message.SERVER_ERROR);
          }
      }

    /**
     * 添加科室
     * @return 反馈信息
     */
    @PostMapping("/departmentinfo/insertADepartment")
    public ResultObject insertADepartment(DepartmentInfo record) {
        if (record == null || record.getDepartmentName() == null) {
            return ResultObject.error("添加科室信息失败，科室名不能为空");
        }
        try {
            record.setDepartmentId(null);
            record.setIsDeleted(NOT_DELETED);
            int inserted = departmentinfoService.insertADepartment(record);
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
     * 按科室名字查找科室
     * @return 科室信息
     */
    @GetMapping("/departmentinfo/selectByDepartmentName")
    public ResultObject selectByDepartmentName(String departmentName) {
        try {
            DepartmentInfo found = departmentinfoService.selectByDepartmentName(departmentName);
            if (found == null) {
                return ResultObject.error("没有找到对应科室");
            } else {
                return ResultObject.success(found);
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
    @RequestMapping("/departmentinfo/batchDelete")
    public ResultObject batchDelete(Integer [] ids){
        try {
            int deleted = this.departmentinfoService.batchDelete(ids);
            if (deleted > 0) {
                return ResultObject.success("删除科室成功");
            } else {
                return ResultObject.error("提供的id均不存在");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultObject.error("删除科室失败");
        }
    }

    /**
     * 部分修改一条坐诊信息(根据departmentId定位)
     * @param departmentInfo
     * @return
     */
    @CrossOrigin
    @PostMapping("/departmentinfo/updateByPrimaryKeySelective")
    public ResultObject updateByPrimaryKeySelective(DepartmentInfo departmentInfo) {
        try {
            int u = departmentinfoService.updateByPrimaryKeySelective(departmentInfo);
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
     * 完全替换一条坐诊信息(根据departmentId定位)
     * @param departmentInfo
     * @return 反馈信息
     */
    @CrossOrigin
    @PostMapping("/departmentinfo/updateByPrimaryKey")
    public ResultObject updateByPrimaryKey(DepartmentInfo departmentInfo) {
        try {
            int u = departmentinfoService.updateByPrimaryKey(departmentInfo);
            if (u == 0) {
                return ResultObject.error("替换失败");
            } else {
                return ResultObject.success("替换成功");
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }

}