package com.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SentinelConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run (SentinelConsumerApplication.class, args);
    }

}
