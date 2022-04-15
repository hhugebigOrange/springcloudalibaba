package com.example.ordernacos.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLoggerConfig {

    @Bean
    public Logger.Level feginLogerLevel(){
        return Logger.Level.FULL;
    }

}
