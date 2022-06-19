package com.dzqc.cloud.controller;

import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.service.DepartmentinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DepartmentinfoController {

      @Autowired
      private DepartmentinfoService departmentinfoService;


      /**
       * 获取所有的科室
       * @return 所有的科室信息
       */
      @CrossOrigin
      @GetMapping("/departmentinfo/list")
      public ResultObject list(){
    	  return ResultObject.success(
    	          departmentinfoService.selectAll()
          );
      }
}