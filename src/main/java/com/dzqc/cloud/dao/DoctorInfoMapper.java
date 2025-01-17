package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.DepartmentInfo;
import com.dzqc.cloud.entity.DoctorInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DoctorInfoMapper {
    int deleteByPrimaryKey(Integer doctorId);

    int insert(DoctorInfo record);

    int insertSelective(DoctorInfo record);

    DoctorInfo selectByPrimaryKey(Integer doctorId);

    int updateByPrimaryKeySelective(DoctorInfo record);

    int updateByPrimaryKey(DoctorInfo record);

    List<DoctorInfo> selectByDepartmentId(Integer departmentId);

    List<DoctorInfo> selectByDepartmentName(String departmentName);

    int softDeleteByPrimaryKey(Integer doctorId);
    DoctorInfo selectBydoctorname(String doctorName);
    List<DoctorInfo> selectAll();
}