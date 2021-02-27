package com.agrimachine.gestiondestock.clients;

import com.agrimachine.gestiondestock.model.Intrant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AGRI-DRIVER-INTRANT-MACHINE")
public interface IntrantClientService
{
    @GetMapping(path = "api/v1/intrant/show/{name}")
    public Intrant show(@PathVariable String name);
}
