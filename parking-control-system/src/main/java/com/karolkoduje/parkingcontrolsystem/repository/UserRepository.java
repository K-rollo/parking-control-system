package com.karolkoduje.parkingcontrolsystem.repository;

import com.karolkoduje.parkingcontrolsystem.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {
}
