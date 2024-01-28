package org.sda.RentCar.service.impl;

import org.sda.RentCar.converter.UserConverter;
import org.sda.RentCar.dto.UserDTO;
import org.sda.RentCar.exception.NotAllowedException;
import org.sda.RentCar.exception.NotFoundException;
import org.sda.RentCar.model.User;
import org.sda.RentCar.repository.UserRepository;
import org.sda.RentCar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO add(UserDTO userDTO) {
        if(!userRepository.findAllByEmail(userDTO.getEmail()).isEmpty()){
            throw new ArithmeticException("Ky email egziston");
        }
        if (!userRepository.findAllByUsername(userDTO.getUsername()).isEmpty()){
            throw new NotAllowedException("Ky username egziston");
        }
        User user= UserConverter.toEntity(userDTO);
        return UserConverter.toDTO( userRepository.save(user));
    }

    @Override
    public void update(UserDTO userDTO) {
        if (!userRepository.findAllByEmail(userDTO.getEmail()).isEmpty()){
            throw new NotAllowedException("This email already exist");
        }

        if(!userRepository.findAllByUsername(userDTO.getUsername()).isEmpty()){
            throw new NotAllowedException("This username already exist");
        }
        User existingUser = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new NotFoundException("Not found"));
        existingUser = UserConverter.toEntityForUpdate(existingUser, userDTO);
        userRepository.save(existingUser);


    }

    @Override
    public void delete(Integer id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found"));
        userRepository.delete(existingUser);


    }

    @Override
    public UserDTO findById(Integer id) {
        Optional<User> returnedUser = userRepository.findById(id);
        if (returnedUser.isPresent()) {
            return UserConverter.toDTO(returnedUser.get());
        } else {
            throw new NotFoundException("User not found");
        }
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(u -> UserConverter.toDTO(u)).toList();
    }

}
