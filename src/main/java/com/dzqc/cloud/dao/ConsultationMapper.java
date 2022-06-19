package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.Consultation;

public interface ConsultationMapper {
    int deleteByPrimaryKey(Integer consultationId);

    int insert(Consultation record);

    int insertSelective(Consultation record);

    Consultation selectByPrimaryKey(Integer consultationId);

    int updateByPrimaryKeySelective(Consultation record);

    int updateByPrimaryKey(Consultation record);
}