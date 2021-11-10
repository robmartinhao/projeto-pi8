package com.rsm.alertaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlertaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlertaApiApplication.class, args);
    }
}
