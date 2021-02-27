package com.agrimachine.gestiondesmachinesagricoles.clients;

import com.agrimachine.gestiondesmachinesagricoles.model.DriverMachine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AGRI-DRIVER-MACHINE")
public interface DriverMachineClientService
{
    @GetMapping(path = "api/V1/driver/getDriverName/{driverName}")
    public DriverMachine getDriver(@PathVariable String driverName);

}
