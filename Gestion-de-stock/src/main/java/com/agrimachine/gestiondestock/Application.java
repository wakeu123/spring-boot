package com.agrimachine.gestiondestock;

import com.agrimachine.gestiondestock.entities.Stock;
import com.agrimachine.gestiondestock.services.StockService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Application
{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner start(StockService stockService) {
        return args -> {
            System.out.println("==== AGRI STOCKS ====");
            //stockService.add(new Stock(null, null, "REF001", 78, 0, null, "Carburation"));
            //stockService.add(new Stock(null, null, "REF002", 0, 90, null, "Garage"));
        };
    }
}
