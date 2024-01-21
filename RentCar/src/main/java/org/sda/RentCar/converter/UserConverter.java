package org.sda.RentCar.converter;

import org.sda.RentCar.dto.UserDTO;
import org.sda.RentCar.model.User;

public class UserConverter {

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
    }

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        return userDTO;

    }

    public static User toEntityForUpdate(User user, UserDTO userDTO) {
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        return user;


    }


}
