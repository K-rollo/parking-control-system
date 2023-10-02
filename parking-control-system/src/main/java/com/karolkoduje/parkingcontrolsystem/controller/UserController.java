package com.karolkoduje.parkingcontrolsystem.controller;

import com.karolkoduje.parkingcontrolsystem.domain.UserAccount;
import com.karolkoduje.parkingcontrolsystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getIndexPage() {
        return "Application started successfully";
    }


    @GetMapping("/users")
    public List<UserAccount> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserAccount getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/add-new-user")
    public String addUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String emailAddress) {
        userService.addUser(firstName, lastName, emailAddress);
        return "User added";
    }

    @DeleteMapping("/user/{id}")    // TODO
    public String deleteUser(@RequestParam Long id) {
        //userService.deleteUser(id);
        return "User deleted";
    }
}
