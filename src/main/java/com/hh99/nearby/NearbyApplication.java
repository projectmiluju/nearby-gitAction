package com.hh99.nearby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NearbyApplication {
    public static void main(String[] args) {
        SpringApplication.run(NearbyApplication.class, args);
    }

}
