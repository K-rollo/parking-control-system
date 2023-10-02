package com.karolkoduje.parkingcontrolsystem.repository;

import com.karolkoduje.parkingcontrolsystem.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    boolean existsByRegistrationPlates(String registrationPlates);
    Optional<Vehicle> findByRegistrationPlates(String registrationPlates);

    Vehicle save(Vehicle vehicle);
    void deleteByRegistrationPlates(String registrationPlates);

}
