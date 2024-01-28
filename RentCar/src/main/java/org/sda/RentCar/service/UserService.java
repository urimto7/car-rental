package org.sda.RentCar.service;

import org.sda.RentCar.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO add(UserDTO userDTO);
    void update(UserDTO userDTO);
    void delete(Integer id);
    UserDTO findById(Integer id);
    List<UserDTO> findAll();




}
