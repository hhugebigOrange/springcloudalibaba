package com.example.stocknacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stockService")
public class StockController {

    @Autowired
    Environment environment;

    @RequestMapping("/reduct")
    public String reduct(){
        return "下单成功，当前服务端口号："+environment.getProperty("local.server.port");
    }

}
