package com.agrimachine.gestiondesmachinesagricoles;

import com.agrimachine.gestiondesmachinesagricoles.entities.Machine;
import com.agrimachine.gestiondesmachinesagricoles.services.MachineServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner start(MachineServices machineServices){
        return args -> {
            //machineServices.addMachine(new Machine(null, "MACHINE001", "TRACTEUR", "ESSENCE", 6L, null));
            //machineServices.addMachine(new Machine(null, "MACHINE002", "COMPACTEUR", "GAZOLE", 2L, null));
            //machineServices.addMachine(new Machine(null, "MACHINE003", "NIVELEUSE", "ESSENCE", 3L, null));
            System.out.println("==== AGRI MACHINE AGRICOLE ====");
        };
    }

}
