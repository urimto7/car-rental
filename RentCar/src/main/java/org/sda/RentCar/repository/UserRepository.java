package org.sda.RentCar.repository;

import org.sda.RentCar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findAllByEmail(String email);
    List<User> findAllByUsername(String username);
}
