package com.paycomo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class ServiceMain {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServiceMain.class, args);
    }
}