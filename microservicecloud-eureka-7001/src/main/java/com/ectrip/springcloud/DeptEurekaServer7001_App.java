package com.ectrip.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DeptEurekaServer7001_App {
    public static void main(String args[]){
        SpringApplication.run(DeptEurekaServer7001_App.class,args);
    }
}
