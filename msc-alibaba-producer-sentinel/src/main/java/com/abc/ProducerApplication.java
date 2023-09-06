package com.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run (ProducerApplication.class, args);
    }

}
