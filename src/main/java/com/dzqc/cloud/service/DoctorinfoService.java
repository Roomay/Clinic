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

    public List<DoctorInfo> selectByDepartmentName(String departmentName) {
        return doctorInfoMapper.selectByDepartmentName(departmentName);
    }

    public int insertADoctor(DoctorInfo doctorInfo) {
        return doctorInfoMapper.insert(doctorInfo);
    }

    public int batchDelete(Integer[] ids) {
        int count = 0;
        for (Integer id : ids) {
            count += doctorInfoMapper.softDeleteByPrimaryKey(id);
        }
        return count;
    }

    public int updateByPrimaryKey(DoctorInfo doctorInfo) {
        return doctorInfoMapper.updateByPrimaryKey(doctorInfo);
    }

    public int updateByPrimaryKeySelective(DoctorInfo doctorInfo) {
        return doctorInfoMapper.updateByPrimaryKeySelective(doctorInfo);
    }
}
