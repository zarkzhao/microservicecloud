package com.ectrip.springcloud.controller;

import com.zzm.springcloud.dto.ResponseResult;
import com.zzm.springcloud.entities.Dept;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptConsumerController {

    @RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST)
    public ResponseResult add(Dept dept){
        return null;
    }

    @RequestMapping(value = "/consumer/dept/get/{id}",method = RequestMethod.GET)
    public ResponseResult get(){
        return null;
    }

    public ResponseResult list(){
        return null;
    }
}
