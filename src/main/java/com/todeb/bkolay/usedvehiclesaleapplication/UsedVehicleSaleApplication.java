package com.todeb.bkolay.usedvehiclesaleapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class UsedVehicleSaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsedVehicleSaleApplication.class, args);
    }

}
