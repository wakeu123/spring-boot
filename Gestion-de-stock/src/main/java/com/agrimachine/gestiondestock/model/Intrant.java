package com.agrimachine.gestiondestock.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class Intrant
{
    private Long id;
    private String intrantName;
    private String description;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "Africa/Douala")
    private Date createdDate;
    private Long macineId;
}
