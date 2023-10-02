package com.karolkoduje.parkingcontrolsystem.domain;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "vehicle")
@Transactional
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id")
    private Long vehicleId;
    private String registrationPlates;
    private String brand;
    private String model;
    private Instant created;

    @Column(name = "fr_user_id")
    private Long frUserId;


    public Vehicle(String registrationPlates, String brand, String model, Long userId) {
        this.registrationPlates = registrationPlates;
        this.brand = brand;
        this.model = model;
        this.frUserId = userId;
        this.created = Instant.now();
    }
}
