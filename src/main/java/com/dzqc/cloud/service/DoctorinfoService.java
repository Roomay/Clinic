package com.dzqc.cloud.service;

import com.dzqc.cloud.dao.DoctorInfoMapper;
import com.dzqc.cloud.entity.DoctorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorinfoService {

    @Autowired
    private DoctorInfoMapper doctorInfoMapper;

    public List<DoctorInfo> selectByDepartmentId(Integer departmentId) {
        return doctorInfoMapper.selectByDepartmentId(departmentId);
    }
}
