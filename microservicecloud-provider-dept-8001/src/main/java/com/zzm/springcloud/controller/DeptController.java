package com.zzm.springcloud.controller;


import com.alibaba.fastjson.JSON;
import com.zzm.springcloud.service.impl.DeptServiceImpl;
import com.zzm.springcloud.dto.MessageCode;
import com.zzm.springcloud.dto.ResponseResult;
import com.zzm.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class DeptController {
    @Autowired
    private DeptServiceImpl deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public ResponseResult list(){
        ResponseResult responseResult=new ResponseResult();
        try{
            List<Dept> deptList=deptService.findAll();
            if(deptList!=null&&deptList.size()>0){
                responseResult.setCode(MessageCode.IS_OK);
                responseResult.setData(JSON.toJSONString(deptList));
            }else{
                responseResult.setCode(MessageCode.IS_OK);
                responseResult.setMessage("暂无数据");
            }
        }catch (Exception e){
            e.printStackTrace();
            responseResult.setCode(MessageCode.IS_ERROR);
            responseResult.setMessage("查询报错，错误信息："+e.getMessage());
        }
        return responseResult;
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id") Long id){
        System.out.println("dept get............");
        ResponseResult responseResult=new ResponseResult();
        try{
            Dept dept=deptService.get(id);
            if(dept!=null){
                responseResult.setCode(MessageCode.IS_OK);
                responseResult.setData(JSON.toJSONString(dept));
            }else{
                responseResult.setCode(MessageCode.IS_FAIL);
                responseResult.setMessage("未查询到信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            responseResult.setCode(MessageCode.IS_ERROR);
            responseResult.setMessage("查询报错，错误信息："+e.getMessage());
        }
        return responseResult;
    }

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public ResponseResult add(@RequestBody Dept dept){
        ResponseResult responseResult=new ResponseResult();
        try{
            Integer result=deptService.add(dept);
            if(result>=1){
                responseResult.setCode(MessageCode.IS_OK);
                responseResult.setData(JSON.toJSONString(dept));
            }else{
                responseResult.setCode(MessageCode.IS_FAIL);
                responseResult.setMessage("新增失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            responseResult.setCode(MessageCode.IS_ERROR);
            responseResult.setMessage("新增报错，错误信息"+e.getMessage());
        }
        return responseResult;
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String>  list=discoveryClient.getServices();
        System.out.println(">>>>>>>>>>>>>client list:"+list);
        List<ServiceInstance> clients=discoveryClient.getInstances("MICROSERVICECLOUD-PROVIDER-DEPT");
        for(ServiceInstance instance:clients){
            System.out.println(">>>>>>>>>>>service info\t serviceId:"+instance.getServiceId()+"\t host:"+instance.getHost()+"\t port:"+instance.getPort()+"\t uri:"+instance.getUri());
        }
        return discoveryClient;
    }
}
