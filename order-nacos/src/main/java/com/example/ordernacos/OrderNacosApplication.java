package com.example.ordernacos;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@RefreshScope
@EnableFeignClients
public class OrderNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderNacosApplication.class, args);
    }

    public String addOrderBlockHandler(BlockException e){
        return "傻逼，限流限流了！！！！！！！！！！";
    }

}
