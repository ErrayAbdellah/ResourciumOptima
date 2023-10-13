package com.resourciumoptima.resourcium_optima.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "departement")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nom", length = 255)
    private String nom;
    @Column(name = "description", length = 255)
    private String description;

    public Departement() {}

    public Departement(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Departement [id=" + id + ", nom=" + nom + ", description=" + description + "]";
    }

}
