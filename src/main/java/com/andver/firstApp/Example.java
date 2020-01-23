package com.andver.firstApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.andver.firstApp.repository")
public class Example {

    public static void main(String[] args) {
        SpringApplication.run(Example.class, args);
    }
}
