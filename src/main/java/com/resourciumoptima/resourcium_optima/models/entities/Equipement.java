package com.resourciumoptima.resourcium_optima.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String type;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_achat")
    private Date dateAchat;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_maintenance")
    private Date dateMaintenance;

    private String etat;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;
}
