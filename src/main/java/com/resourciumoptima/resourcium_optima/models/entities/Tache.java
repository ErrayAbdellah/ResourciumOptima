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
public class Tache {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "limite")
    private Date dateLimite;

    @Column(name = "priorite")
    private int priorite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user ;

}
