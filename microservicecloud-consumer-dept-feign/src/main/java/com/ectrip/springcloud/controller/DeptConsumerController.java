package com.ectrip.springcloud.controller;

import com.zzm.springcloud.dto.ResponseResult;
import com.zzm.springcloud.entities.Dept;
import com.zzm.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DeptConsumerController {
    // private static final String REST_URL_PREFIX="http://localhost:8001";
    // private static final String REST_URL_PREFIX="http://MICROSERVICECLOUD-PROVIDER-DEPT"; //加入ribbon之后

    @Autowired
    private DeptClientService service=null;

    @RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST)
    public ResponseResult add(Dept dept){
        return service.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id") Long id){
        return service.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return service.list();
    }

}
