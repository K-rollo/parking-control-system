package com.karolkoduje.parkingcontrolsystem.service;

import com.karolkoduje.parkingcontrolsystem.domain.Vehicle;
import com.karolkoduje.parkingcontrolsystem.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;
    private UserService userService;

    public VehicleService(VehicleRepository vehicleRepository, UserService userService) {
        this.vehicleRepository = vehicleRepository;
        this.userService = userService;
    }


    public boolean isVehicleInRegister(String registrationPlates) {
        return vehicleRepository.existsByRegistrationPlates(registrationPlates);
    }

    public Vehicle getVehicle(String registrationPlates) {
        return vehicleRepository.findByRegistrationPlates(registrationPlates).orElseThrow();
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public void addVehicle(String registrationPlates, String brand, String model, Long userId) {
        if (!isVehicleInRegister(registrationPlates)) {
            if (userService.existsById(userId)) {
                var foundUser = userService.getUser(userId);
                vehicleRepository.save(new Vehicle(registrationPlates, brand, model, userId));
            }
        }
    }

    public void deleteVehicle(String registrationPlates) {
        vehicleRepository.deleteByRegistrationPlates(registrationPlates);
    }

}
