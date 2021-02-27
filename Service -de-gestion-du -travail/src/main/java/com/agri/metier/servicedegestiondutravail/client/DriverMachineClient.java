package com.agri.metier.servicedegestiondutravail.client;

import com.agri.metier.servicedegestiondutravail.models.DriverMachine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AGRI-DRIVER-MACHINE")
public interface DriverMachineClient
{
    @GetMapping(path = "/api/V1/driver/getDriverName/{name}")
    public DriverMachine getDriverByName(@PathVariable("name") String nameDriver);
}
