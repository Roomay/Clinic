package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.AdminInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminInfoMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(AdminInfo record);

    int insertSelective(AdminInfo record);

    AdminInfo selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(AdminInfo record);

    int updateByPrimaryKey(AdminInfo record);
}