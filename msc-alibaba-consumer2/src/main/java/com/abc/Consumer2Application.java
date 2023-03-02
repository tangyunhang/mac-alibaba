package com.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Consumer2Application {

    public static void main(String[] args) {
        SpringApplication.run (Consumer2Application.class, args);
    }

}
