package com.example.ordernacos;

import com.example.config.RibbonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
//@RibbonClients(
//        value = {
//                @RibbonClient(name = "stock-service",configuration = RibbonConfig.class)
//        }
//)
public class OrderRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        RestTemplate restTemplate=restTemplateBuilder.build();
        return restTemplate;
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/addOrder")
    public String addOrder(){
        String forObject = restTemplate.getForObject("http://stock-service/stock", String.class);
        return forObject;
    }

}
