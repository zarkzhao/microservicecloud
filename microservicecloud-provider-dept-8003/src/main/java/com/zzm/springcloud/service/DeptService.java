package com.zzm.springcloud.service;

import com.zzm.springcloud.dto.ResponseResult;
import com.zzm.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {

    Integer add(Dept dept) throws Exception;

    Dept get(Long id) throws Exception;

    List findAll();
}
