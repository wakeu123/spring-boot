package com.metier.conducteurservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mobile", types = DriverMachine.class)
public interface DriverMachineProjection2
{
    public Long getId();
    public String getName();
    public String getAdress();
    public String getCni();
}
