package com.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Producer2Application {

    public static void main(String[] args) {
        SpringApplication.run (Producer2Application.class, args);
    }

}
