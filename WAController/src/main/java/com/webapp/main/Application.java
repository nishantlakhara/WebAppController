package com.webapp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//    	System.setProperty("server.port", "9990");
        SpringApplication.run(Application.class, args);
    }
}