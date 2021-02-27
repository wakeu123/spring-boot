package com.agrimachine.gestiondesintrantsagricoles.model;

import lombok.Data;

@Data
public class Machine
{
    private Long id;
    private String matriculeMachine;
    private String machineName;
    private String typeCarburation;
    private Long driverMachineId;
}
