package com.dzqc.cloud.service;

import com.dzqc.cloud.dao.DepartmentInfoMapper;
import com.dzqc.cloud.entity.DepartmentInfo;
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
