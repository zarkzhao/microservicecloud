package com.zzm.springcloud.controller;


import com.alibaba.fastjson.JSON;
import com.zzm.springcloud.service.impl.DeptServiceImpl;
import com.zzm.springcloud.dto.MessageCode;
import com.zzm.springcloud.dto.ResponseResult;
import com.zzm.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
public class DeptController {
    @Autowired
    private DeptServiceImpl deptService;

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
        ResponseResult responseResult=new ResponseResult();
        try{
            Dept dept=null;
            dept=deptService.get(id);
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
}
