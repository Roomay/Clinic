package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.DepartmentInfo;

public interface DepartmentInfoMapper {
    int deleteByPrimaryKey(Integer departmentId);

    int insert(DepartmentInfo record);

    int insertSelective(DepartmentInfo record);

    DepartmentInfo selectByPrimaryKey(Integer departmentId);

    int updateByPrimaryKeySelective(DepartmentInfo record);

    int updateByPrimaryKey(DepartmentInfo record);
}