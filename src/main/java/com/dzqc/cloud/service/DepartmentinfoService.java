package com.dzqc.cloud.service;

import com.dzqc.cloud.entity.DepartmentInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentinfoService {

    public List<DepartmentInfo> selectAll();


}
