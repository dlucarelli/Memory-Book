package com.example.dylanlucarellicapstone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DylanLucarelliCapstoneApplication {

    public static void main(String[] args) {

        SpringApplication.run(DylanLucarelliCapstoneApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> System.out.println("My application got started!!");
    }
}
