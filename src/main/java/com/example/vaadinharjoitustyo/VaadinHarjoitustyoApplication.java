package com.example.vaadinharjoitustyo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.vaadinharjoitustyo.entity")
@EnableJpaRepositories("com.example.vaadinharjoitustyo.repository")
public class VaadinHarjoitustyoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VaadinHarjoitustyoApplication.class, args);
    }

}
