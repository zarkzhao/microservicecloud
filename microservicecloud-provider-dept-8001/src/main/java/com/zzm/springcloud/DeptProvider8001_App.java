package com.zzm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient    // 有了这个注解服务会自动注册到注册中心
public class DeptProvider8001_App {
    public static void main(String args[]){
        SpringApplication.run(DeptProvider8001_App.class,args);
    }
}
