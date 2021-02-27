package com.agrimachine.gestiondestock.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Stock")
@Table(
        name = "stocks",
        uniqueConstraints = {
                @UniqueConstraint(name = "agri_stock_pieceName_unique", columnNames = "piece_name"),
                @UniqueConstraint(name = "agri_stock_reference_piece", columnNames = "reference_piece")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "piece_name", nullable = false, length = 20)
    private String pieceName;

    @Column(name = "reference_piece", nullable = false)
    private String referencePiece;

    @Column(name = "quantite_entree", nullable = true)
    private int quatitEntrer;

    @Column(name = "quantite_sortie", nullable = true)
    private int quatiteSortie;

    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "Africa/Douala")
    private Date createdDate;

    @Transient
    private String intrantName;


}
