package com.dzqc.cloud.service;

import com.dzqc.cloud.dao.DepartmentInfoMapper;
import com.dzqc.cloud.entity.Consultation;
import com.dzqc.cloud.entity.DepartmentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentinfoService {

    @Autowired
    private DepartmentInfoMapper departmentinfoMapper;

    public List<DepartmentInfo> selectAll() {
        return departmentinfoMapper.selectAll();
    }

    public int insertADepartment(DepartmentInfo departmentInfo) {
        return departmentinfoMapper.insert(departmentInfo);
    }

    public DepartmentInfo selectByDepartmentName(String departmentName) {
        return departmentinfoMapper.selectByDepartmentName(departmentName);
    }

    public int batchDelete(Integer[] ids) {
        int count = 0;
        for (Integer id : ids) {
            count += departmentinfoMapper.softDeleteByPrimaryKey(id);
        }
        return count;
    }

    public int updateByPrimaryKeySelective(DepartmentInfo departmentInfo) {
        return departmentinfoMapper.updateByPrimaryKeySelective(departmentInfo);
    }

    public int updateByPrimaryKey(DepartmentInfo departmentInfo) {
        return departmentinfoMapper.updateByPrimaryKey(departmentInfo);
    }
}
