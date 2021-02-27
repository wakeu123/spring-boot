package com.agrimachine.gestiondesmachinesagricoles.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Machine")
@Table(
        name = "machine_agricole",
        uniqueConstraints =
        {
            @UniqueConstraint(name = "machine_agricole_immatricule_machine_unique", columnNames = "immatricule_machine")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Machine implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "immatricule_machine",nullable = false)
    private String matriculeMachine;

    @Column(name = "machine_name",nullable = false)
    private String machineName;

    @Column(name = "type_consommation_carburant", nullable = false, length = 10)
    private String typeCarburation;

    @Column(nullable = true)
    private Long driverMachineId;

    @Transient
    private String driverMachineName;
}
