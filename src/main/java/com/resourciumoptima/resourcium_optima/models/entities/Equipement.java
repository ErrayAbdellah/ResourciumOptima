package com.resourciumoptima.resourcium_optima.models.entities;

import com.resourciumoptima.resourcium_optima.enums.Etat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "equipment")
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_achat")
    private Date dateAchat;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_maintenance")
    private Date dateMaintenance;

    @Column(name = "etat")
    private Etat etat;

    @OneToMany(mappedBy = "equipement")
    private List<Reservation> reservations;

}
