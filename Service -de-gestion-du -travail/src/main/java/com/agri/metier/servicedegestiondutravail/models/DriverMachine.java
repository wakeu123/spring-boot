package com.agri.metier.servicedegestiondutravail.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class DriverMachine
{
    private Long id;
    private String matricule;
    private String name;
    private String secondName;
    private String cni;
    private String numberPhone;
    private String email;
    private String adress;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "Africa/Douala")
    private Date birthDay;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "Africa/Douala")
    private Date createDate;
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss", locale = "fr-FR", timezone = "Africa/Douala")
    private Date createTime;
}
