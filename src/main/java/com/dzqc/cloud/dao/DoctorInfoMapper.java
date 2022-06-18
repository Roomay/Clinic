package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.DoctorInfo;
import com.dzqc.cloud.entity.DoctorInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctorInfoMapper {
    int countByExample(DoctorInfoExample example);

    int deleteByExample(DoctorInfoExample example);

    int deleteByPrimaryKey(Integer doctorId);

    int insert(DoctorInfo record);

    int insertSelective(DoctorInfo record);

    List<DoctorInfo> selectByExample(DoctorInfoExample example);

    DoctorInfo selectByPrimaryKey(Integer doctorId);

    int updateByExampleSelective(@Param("record") DoctorInfo record, @Param("example") DoctorInfoExample example);

    int updateByExample(@Param("record") DoctorInfo record, @Param("example") DoctorInfoExample example);

    int updateByPrimaryKeySelective(DoctorInfo record);

    int updateByPrimaryKey(DoctorInfo record);
}