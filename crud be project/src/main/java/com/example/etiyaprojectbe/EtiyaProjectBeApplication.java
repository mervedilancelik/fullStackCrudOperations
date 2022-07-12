package com.example.etiyaprojectbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EtiyaProjectBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtiyaProjectBeApplication.class, args);
    }

}
