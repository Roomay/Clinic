package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.DepartmentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface DepartmentInfoMapper {
    int deleteByPrimaryKey(Integer departmentId);

    int insert(DepartmentInfo record);

    int insertSelective(DepartmentInfo record);

    DepartmentInfo selectByPrimaryKey(Integer departmentId);

    int updateByPrimaryKeySelective(DepartmentInfo record);

    int updateByPrimaryKey(DepartmentInfo record);

    List<DepartmentInfo> selectAll();

    DepartmentInfo selectByDepartmentName(String departmentName);

    int softDeleteByPrimaryKey(Integer departmentId);
}