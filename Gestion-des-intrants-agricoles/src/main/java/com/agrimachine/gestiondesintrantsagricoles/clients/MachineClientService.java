package com.agrimachine.gestiondesintrantsagricoles.clients;

import com.agrimachine.gestiondesintrantsagricoles.model.Machine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MACHINE-AGRICOLE")
public interface MachineClientService
{
    @GetMapping(path = "api/v1/machine/getMachine/{immatricule}")
    public Machine getMachine(@PathVariable String immatricule);
}
