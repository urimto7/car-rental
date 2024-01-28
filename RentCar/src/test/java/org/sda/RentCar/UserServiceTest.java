package org.sda.RentCar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sda.RentCar.dto.UserDTO;
import org.sda.RentCar.exception.NotAllowedException;
import org.sda.RentCar.model.User;
import org.sda.RentCar.repository.UserRepository;
import org.sda.RentCar.service.UserService;
import org.sda.RentCar.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private UserDTO userToSave ;
    private User user;

    @BeforeEach
    public void setUp(){
        initUserDTO();
        initUser();
    }

    private void initUserDTO() {
        userToSave = new UserDTO();
        userToSave.setUsername("test");
        userToSave.setRole("test");
        userToSave.setPassword("test");
        userToSave.setEmail("email@gmail.com");
        userToSave.setName("name");
        userToSave.setLastName("lastName");
    }
    private void initUser() {
        user = new User();
        user.setUsername("test");
        user.setRole("test");
        user.setPassword("test");
        user.setEmail("email@gmail.com");
        user.setName("name");
        user.setLastName("lastName");
    }

    @Test
    void saveUserTest_IsOK(){
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);
        UserDTO userDTO = userService.add(userToSave);
        Assertions.assertEquals(this.userToSave.getEmail(), userDTO.getEmail());
        Assertions.assertEquals(this.userToSave.getName(), userDTO.getName());
        Assertions.assertEquals(this.userToSave.getUsername(), userDTO.getUsername());
        Assertions.assertEquals(this.userToSave.getLastName(), userDTO.getLastName());
    }

    @Test
    void saveUserTest_IsNotOk_EmailExists(){
        Mockito.when(userRepository.findAllByEmail(userToSave.getEmail())).thenReturn(Arrays.asList(user));
        Assertions.assertThrows(ArithmeticException.class, () -> userService.add(userToSave));
    }

    @Test
    void saveUserTest_IsNotOk_UsernameExists(){
        Mockito.when(userRepository.findAllByUsername(userToSave.getUsername())).thenReturn(Arrays.asList(user));
        Assertions.assertThrows(NotAllowedException.class, () -> userService.add(userToSave));
    }
}
