package com.resourciumoptima.resourcium_optima.models.entities;

import com.resourciumoptima.resourcium_optima.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private Role role ;

    @Column(name = "dateEmbauche")
    @Temporal(TemporalType.DATE)
    private Date dateEmbauche;

    @OneToMany(mappedBy = "user")
    private List<Tache> taches ;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservation ;

}
