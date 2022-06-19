package com.dzqc.cloud.service.impl;

import com.dzqc.cloud.dao.DepartmentInfoMapper;
import com.dzqc.cloud.entity.DepartmentInfo;
import com.dzqc.cloud.service.DepartmentinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentinfoServiceImpl implements DepartmentinfoService {

    @Autowired
    private DepartmentInfoMapper departmentinfoMapper;



    @Override
    public List<DepartmentInfo> selectAll() {
        return departmentinfoMapper.selectAll();
    }
}
