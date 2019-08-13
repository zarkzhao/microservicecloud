package com.zzm.springcloud.service;

import com.zzm.springcloud.dto.ResponseResult;
import com.zzm.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "MICROSERVICECLOUD-PROVIDER-DEPT")
public interface DeptClientService {
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public ResponseResult list();

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id") Long id);

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public ResponseResult add(@RequestBody Dept dept);
}
