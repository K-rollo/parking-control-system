package com.karolkoduje.parkingcontrolsystem.service;

import com.karolkoduje.parkingcontrolsystem.domain.UserAccount;
import com.karolkoduje.parkingcontrolsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserAccount> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }
    public UserAccount getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
    public void addUser(String firstName, String lastName, String emailAddress) {
        userRepository.save(new UserAccount(firstName, lastName, emailAddress));
    }
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
