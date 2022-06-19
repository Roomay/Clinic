package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.MedicalRecord;
import com.dzqc.cloud.entity.MedicalRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface MedicalRecordMapper {
    int countByExample(MedicalRecordExample example);

    int deleteByExample(MedicalRecordExample example);

    int deleteByPrimaryKey(Integer recordId);

    int insert(@RequestBody MedicalRecord record);

    int insertSelective(MedicalRecord record);

    List<MedicalRecord> selectByExample(MedicalRecordExample example);

    MedicalRecord selectByPrimaryKey(Integer recordId);

    int updateByExampleSelective(@Param("record") MedicalRecord record, @Param("example") MedicalRecordExample example);

    int updateByExample(@Param("record") MedicalRecord record, @Param("example") MedicalRecordExample example);

    int updateByPrimaryKeySelective(MedicalRecord record);

    int updateByPrimaryKey( MedicalRecord record);


}