package com.zzm.springcloud.dao;

import com.zzm.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {

    Integer insertObject(Dept dept);

    Dept findById(Long id);

    List findAll();
}
