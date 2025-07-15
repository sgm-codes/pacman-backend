package com.pacman.infrastructure.entrypoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.pacman")
public class PacmanApplication {
    public static void main(String[] args) {
        SpringApplication.run(PacmanApplication.class, args);
    }
}
