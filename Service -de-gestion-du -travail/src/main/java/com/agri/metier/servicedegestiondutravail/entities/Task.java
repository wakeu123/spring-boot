package com.agri.metier.servicedegestiondutravail.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Task")
@Table(
        name = "tasks",
        uniqueConstraints = {
                @UniqueConstraint(name = "driver_reference_unique", columnNames = "reference")
        }
    )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference", nullable = false)
    private String refTask;

    @Column(name = "name_task", nullable = false)
    private String name;

    @Column(name = "description", length = 100, nullable = true)
    private String description;

    @Column(name = "date_execution", nullable = true)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "Africa/Douala")
    private Date executionDate;

    @Column(name = "heure_debut_execution", nullable = true)
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss", locale = "fr-FR", timezone = "Africa/Douala")
    private Date timeStart;

    @Column(name = "heure_fin_execution", nullable = false)
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss", locale = "fr-FR", timezone = "Africa/Douala")
    private Date timeInd;

    @Column(name = "driverMachineId", nullable = false)
    private Long driverMachineId;

    @Column(name = "creata_date", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "Africa/Douala")
    private Date createDate;

    @Column(name = "create_time", nullable = false)
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss", locale = "fr-FR", timezone = "Africa/Douala")
    private Date createTime;

    @Transient
    private String driverMachineName;
}
