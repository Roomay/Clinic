package com.dzqc.cloud.controller;
import com.dzqc.cloud.common.Message;
import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.entity.PatientInfo;
import com.dzqc.cloud.service.PatientService;
import com.dzqc.cloud.util.SendSmsUtil;
import com.dzqc.cloud.util.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    /**
     * login
     * @return
     */
    @CrossOrigin
    @RequestMapping( "/user/selectByusernme")
    public ResultObject selectByusername(String username,String password) {
        try {
            PatientInfo patientInfo = this.patientService.login(username);
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





    /**
     * 退出
     * @param request
     * @returnd
     */
    @RequestMapping("/shiro/logout")
    public ResultObject logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("userinfo");
        return ResultObject.success("成功注销");
    }



}