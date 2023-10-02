package com.karolkoduje.parkingcontrolsystem.domain;


import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_account")
@Transactional
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Instant created;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fr_user_id", referencedColumnName = "user_id")
    private List<Vehicle> vehicle;


    public UserAccount(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.created = Instant.now();
    }
}
