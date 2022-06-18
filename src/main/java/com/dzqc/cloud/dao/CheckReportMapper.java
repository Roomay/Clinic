package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.CheckReport;

public interface CheckReportMapper {
    int deleteByPrimaryKey(Integer reportId);

    int insert(CheckReport record);

    int insertSelective(CheckReport record);

    CheckReport selectByPrimaryKey(Integer reportId);

    int updateByPrimaryKeySelective(CheckReport record);

    int updateByPrimaryKey(CheckReport record);
}