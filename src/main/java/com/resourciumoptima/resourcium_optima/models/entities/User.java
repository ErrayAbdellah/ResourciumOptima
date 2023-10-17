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
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "email")
    private String nomUtilisateur;

    @Column(name = "motdepasse")
    private String motdepasse;

    @Column(name = "poste")
    private String poste;

    @Column(name = "dateEmbauche")
    @Temporal(TemporalType.DATE)
    private Date dateEmbauche;


}
