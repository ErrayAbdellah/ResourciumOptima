package com.resourciumoptima.resourcium_optima.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "reservation")
    private List<Equipement> equipements ;

}
