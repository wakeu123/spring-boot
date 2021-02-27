package com.metier.conducteurservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "DriverMachine")
@Table(
        name = "driver",
        uniqueConstraints = {
                @UniqueConstraint(name = "driver_name_unique", columnNames = "name"),
                @UniqueConstraint(name = "driver_surname_unique", columnNames = "surname"),
                @UniqueConstraint(name = "driver_matricule_unique", columnNames = "mat"),
                @UniqueConstraint(name = "driver_cni_unique", columnNames = "cni"),
                @UniqueConstraint(name = "driver_email_unique", columnNames = "email"),
                @UniqueConstraint(name = "driver_phone_unique", columnNames = "phone")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverMachine implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mat", nullable = false)
    private String matricule;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String secondName;

    @Column(name = "cni", nullable = false)
    private String cni;
    @Column(name = "phone", nullable = false)
    private String numberPhone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "adress", nullable = false)
    private String adress;

    @Column(name = "birthday", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "Africa/Douala")
    private Date birthDay;

    @Column(name = "creata_date", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "Africa/Douala")
    private Date createDate;

    @Column(name = "create_time", nullable = false)
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss", locale = "fr-FR", timezone = "Africa/Douala")
    private Date createTime;

}
