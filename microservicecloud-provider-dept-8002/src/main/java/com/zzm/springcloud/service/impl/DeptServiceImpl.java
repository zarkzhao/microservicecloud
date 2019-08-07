package com.zzm.springcloud.service.impl;

import com.zzm.springcloud.dao.DeptDao;
import com.zzm.springcloud.dto.ResponseResult;
import com.zzm.springcloud.service.DeptService;
import com.zzm.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public Integer add(Dept dept) throws Exception{
        Integer result=0;
        result=deptDao.insertObject(dept);
        return result;
    }

    @Override
    public Dept get(Long id) throws Exception {
        return deptDao.findById(id);
    }

    @Override
    public List findAll() {
        return deptDao.findAll();
    }
}
