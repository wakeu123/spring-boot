package com.agrimachine.gestiondesintrantsagricoles;

import com.agrimachine.gestiondesintrantsagricoles.entities.Intrant;
import com.agrimachine.gestiondesintrantsagricoles.services.IntrantService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner start(IntrantService intrantService){
        return args -> {
            System.out.println("==== AGRI INTRANT MACHINE ====");
            //intrantService.add(new Intrant(null,"Carburation","Carburation pour netoyage",null,null,"MACHINE001"));
            //intrantService.add(new Intrant(null,"Garage","Réparation des pneuds",null,null,"MACHINE002"));
        };
    }

}
