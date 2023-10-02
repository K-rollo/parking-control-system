package com.karolkoduje.parkingcontrolsystem.controller;

import com.karolkoduje.parkingcontrolsystem.domain.Vehicle;
import com.karolkoduje.parkingcontrolsystem.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/vehicle/{}")
    public Vehicle getVehicle(@RequestParam String registrationPlates){
        return vehicleService.getVehicle(registrationPlates);
    }

    @PostMapping("/vehicle")
    public String addVehicle(@RequestParam String registrationPlates, @RequestParam String brand, @RequestParam String model, @RequestParam Long userId) {
        vehicleService.addVehicle(registrationPlates, brand, model, userId);
        return "Vehicle Added";
    }

    @DeleteMapping("/vehicle/{}")
    public void deleteVehicle(@RequestParam String registrationPlates) {
        vehicleService.deleteVehicle(registrationPlates);
    }
}
