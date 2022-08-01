package com.dzqc.cloud.service;

import com.dzqc.cloud.dao.LoginTicketMapper;
import com.dzqc.cloud.dao.PatientInfoMapper;
import com.dzqc.cloud.entity.LoginTicket;
import com.dzqc.cloud.entity.PatientInfo;
import com.dzqc.cloud.util.EncodeMD5;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class PatientService  {

    @Autowired
    private PatientInfoMapper patientInfoMapper;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    private long expiredSeconds = 60 * 60 * 24;

    public PatientInfo findPatientById(int id) {
        return patientInfoMapper.selectByPrimaryKey(id);
    }

    public Map<String, Object> register(PatientInfo patient) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        if (patient == null) {
            throw new IllegalAccessException("参数不能为空!");
        }

        if (StringUtils.isBlank(patient.getPatientName())) {
            map.put("usernameMsg", patient.getPatientName());

            return map;
        }

        if (StringUtils.isBlank(patient.getPassword())) {
            map.put("passwordMsg", "密码不能为空");
            return map;
        }



        if (StringUtils.isBlank(patient.getPhone())) {
            map.put("phoneMsg", "电话不能为空");
            return map;
        }

        //验证账号
        PatientInfo p = patientInfoMapper.selectByUsername(patient.getPatientName());
        if (p != null) {
            map.put("usernameMsg", "账号已存在");
        }

        //验证身份证？需要验证这个吗？

        //注册
        patient.setPatientName(patient.getPatientName());
        patient.setPassword(patient.getPassword());
        patient.setPhone(patient.getPhone());
        patient.setBirthday(patient.getBirthday());
        patient.setGender(patient.getGender());
        patient.setIsDeleted(0);
        patientInfoMapper.insert(patient);

        return map;

    }

    public Map<String, Object> login(String patientName, String password, int expired) {
        Map<String, Object> map = new HashMap<>();
        //null的处理
        if (StringUtils.isBlank(patientName)) {
            map.put("usernameMsg", "账号不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)) {
            map.put("passwordMsg", "密码不能为空");
            return map;
        }

        //验证账号
        PatientInfo patient = patientInfoMapper.selectByUsername(patientName);
        if(patient == null) {
            map.put("usernameMsg", "该账号不存在");
            return map;
        }

        //验证密码
        if(!patient.getPassword().equals(password)) {
            map.put("passwordMsg", "密码不正确");
            return map;
        }

        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(patient.getPatientId());
        loginTicket.setTicket(EncodeMD5.generateUUID());
        loginTicket.setExpired(new Date(System.currentTimeMillis() + expiredSeconds * 1000));

        loginTicketMapper.insertLoginTicket(loginTicket);

        map.put("ticket", loginTicket.getTicket());

        return map;
    }


    public void logout(String ticket) {
        loginTicketMapper.updateStatus(ticket, 1);
        return;
    }

    public PatientInfo selectByUsername(String username) {
        return patientInfoMapper.selectByUsername(username);
    }
}
