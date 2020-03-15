package com.nicolea.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "service-products")
@EnableFeignClients
@SpringBootApplication
public class SpringServicioItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringServicioItemApplication.class, args);
    }

}
