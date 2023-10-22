package com.resourciumoptima.resourcium_optima.models.entities;

import com.resourciumoptima.resourcium_optima.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role", columnDefinition = "VARCHAR(255) DEFAULT 'EMPLOYER'")
    private String role ;

    @Column(name = "dateEmbauche")
    @Temporal(TemporalType.DATE)
    private Date dateEmbauche;

    @OneToMany(mappedBy = "user")
    private List<Tache> taches ;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservation ;

}
