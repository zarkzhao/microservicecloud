package com.ectrip.springcloud.controller;

import com.zzm.springcloud.dto.ResponseResult;
import com.zzm.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DeptConsumerController {
    private static final String REST_URL_PREFIX="http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST)
    public ResponseResult add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,ResponseResult.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,ResponseResult.class);
    }


    public ResponseResult list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",ResponseResult.class);
    }
}
