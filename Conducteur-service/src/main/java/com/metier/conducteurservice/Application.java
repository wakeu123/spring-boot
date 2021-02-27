package com.metier.conducteurservice;

import com.metier.conducteurservice.entities.DriverMachine;
import com.metier.conducteurservice.services.DriverMachineService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner start(RepositoryRestConfiguration restConfiguration, DriverMachineService driverMachineService){
        return args -> {
            restConfiguration.exposeIdsFor(DriverMachine.class);
            System.out.println("==== AGRI DRIVER MACHINE SERVICE ====");
           //driverMachineService.addDriverMachine( new DriverMachine(null, "MAT2021011778", "Julio", "Nita", "117624354321", "696754321", "nita@gmail.com", "Douala", new Date(), new Date(), new Date()));
        };
    }
}
