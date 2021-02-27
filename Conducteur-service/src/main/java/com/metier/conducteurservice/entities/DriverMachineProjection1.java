package com.metier.conducteurservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "web", types = DriverMachine.class)
public interface DriverMachineProjection1
{
    public String getName();
}

