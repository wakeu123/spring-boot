package com.agrimachine.gestiondesintrantsagricoles.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "IntrantMachine")
@Table(name = "intrant_machine")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Intrant implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "intrant_name", nullable = false)
    private String intrantName;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "creata_date", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "Africa/Douala")
    private Date createdDate;

    @Column(nullable = false)
    private Long macineId;

    @Transient
    private String immatriculeMachine;
}
