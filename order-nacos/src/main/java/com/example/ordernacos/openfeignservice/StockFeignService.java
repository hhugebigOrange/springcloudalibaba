package com.example.ordernacos.openfeignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="stock-service",path="stockService")
public interface StockFeignService {

    @RequestMapping("/reduct")
    String reduct();

}
