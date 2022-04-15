package com.example.ordernacos.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.ordernacos.openfeignservice.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orderService")
public class OrderController {

    @Value("${common.version}")
    public String config1;

    @RequestMapping("/getConfig1")
    public String getConfig1(){
        return config1;
    }

    @Autowired
    StockFeignService stockFeignService;

    @RequestMapping("/addOrder")
    @SentinelResource(value = "addOrder",blockHandler ="addOrderBlockHandler" )
    public String addOrder(){
        String forObject = stockFeignService.reduct();
        return forObject;
    }

    @RequestMapping("/addOrderThread")
    @SentinelResource(value = "addOrderThread",blockHandler ="addOrderBlockHandler" )
    public String addOrderThread(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "FUCKFUCKFUCK";
    }

}
