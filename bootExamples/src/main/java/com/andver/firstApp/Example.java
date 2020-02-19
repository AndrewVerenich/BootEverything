package com.andver.firstApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Example {

    public static void main(String[] args) {
        SpringApplication.run(Example.class, args);
    }
}
