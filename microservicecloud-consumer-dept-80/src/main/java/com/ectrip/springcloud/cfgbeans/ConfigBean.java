package com.ectrip.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 类似于  applicationContext.xml里面注入 bean 本次只注入 RestTemplate
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced  //获取rest服务时 加入ribbon配置
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        //return new RoundRobinRule();  //轮询 ribbon 默认的负载均衡方式
        // return new RandomRule(); // 随机访问
        return new RetryRule(); //
        // return new MyRibbonRule();  //自定义负载均衡方式 在源码基础之上修改
    }
}
