package com.agri.metier.servicedegestiondutravail;

import com.agri.metier.servicedegestiondutravail.entities.Task;
import com.agri.metier.servicedegestiondutravail.services.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner start(TaskService taskService){
        return args -> {

            SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
            df1.setTimeZone(TimeZone.getTimeZone("Africa/Douala"));
            Date date  = null;
            try {
                date = df1.parse(df1.format(new Date()));
            }catch (ParseException e){
                e.printStackTrace();
            }

            SimpleDateFormat df2 = new SimpleDateFormat("HH:mm:ss");
            df2.setTimeZone(TimeZone.getTimeZone("Africa/Douala"));
            Date heure  = null;
            try {
                heure = df2.parse(df2.format(new Date()));
            }catch (ParseException e){
                e.printStackTrace();
            }


            System.out.println("==== AGRI TASKS ====");
            //taskService.addTask(new Task(null, "REF002", "Deuxième taches", "Labourage", new Date(), heure, heure, null, null, null,"Julio"));
        };
    }
}
