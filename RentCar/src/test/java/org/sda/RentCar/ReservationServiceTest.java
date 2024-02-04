package org.sda.RentCar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sda.RentCar.dto.CarDTO;
import org.sda.RentCar.dto.ReservationsDTO;
import org.sda.RentCar.dto.UserDTO;
import org.sda.RentCar.model.Car;
import org.sda.RentCar.model.Reservations;
import org.sda.RentCar.model.User;
import org.sda.RentCar.repository.CarRepository;
import org.sda.RentCar.repository.ReservationsRepository;
import org.sda.RentCar.repository.UserRepository;
import org.sda.RentCar.service.impl.ReservationsServiceImpl;

import java.util.Arrays;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {
    @Mock
    private ReservationsRepository reservationsRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private ReservationsServiceImpl reservationsService;

    private ReservationsDTO reservationToSave;
    private Reservations reservations;
    private Car car;
    private User user;

    @BeforeEach
    public void setUp(){
        initReservations();
        initReservationsDTO();

    }
    private void initReservationsDTO(){
        CarDTO carDTO = new CarDTO();
        carDTO.setModel("X6");
        carDTO.setHp(124);
        carDTO.setTransmission_type("automatic");
        carDTO.setBrand("BMW");
        carDTO.setFuel_type("diesel");
        carDTO.setBody_type("sedan");
        UserDTO userDTO=new UserDTO();
        userDTO.setUsername("test");
        userDTO.setRole("test");
        userDTO.setPassword("test");
        userDTO.setEmail("email@gmail.com");
        userDTO.setName("name");
        userDTO.setLastName("lastName");
        reservationToSave = new ReservationsDTO();
        reservationToSave.setDays(9);
        reservationToSave.setCarDTO(carDTO);
        reservationToSave.setPickUpDate("20-02-2024");
        reservationToSave.setUsername("fitimhh");
        reservationToSave.setStatus("Confirmed");
        reservationToSave.setUserDTO(userDTO);

    }
    private void initReservations(){
        this.car = new Car();
        car.setModel("X6");
        car.setHp(124);
        car.setTransmission_type("automatic");
        car.setBrand("BMW");
        car.setFuel_type("diesel");
        car.setBody_type("sedan");

        this.user=new User();
        user.setUsername("test");
        user.setRole("test");
        user.setPassword("test");
        user.setEmail("email@gmail.com");
        user.setName("name");
        user.setLastName("lastName");
        reservations = new Reservations();
        reservations.setDays(9);
        reservations.setCar(car);
        reservations.setPickupDate("20-02-2024");
        reservations.setUsername("fitimhh");
        reservations.setStatus("Confirmed");
        reservations.setUser(user);
    }
    @Test
    void saveCarTest_IsOK(){
        Mockito.when(reservationsRepository.save(Mockito.any())).thenReturn(reservations);
        Mockito.when(userRepository.findById(Mockito.any())).thenReturn(Optional.of(user));
        Mockito.when(carRepository.findById(Mockito.any())).thenReturn(Optional.of(car));

        ReservationsDTO reservationsDTO = reservationsService.add(reservationToSave);
        Assertions.assertEquals(this.reservationToSave.getDays(),reservationsDTO.getDays());
        Assertions.assertEquals(this.reservationToSave.getCarDTO(),reservationsDTO.getCarDTO());
        Assertions.assertEquals(this.reservationToSave.getUserDTO(),reservationsDTO.getUserDTO());
        Assertions.assertEquals(this.reservationToSave.getUsername(),reservationsDTO.getUsername());
        Assertions.assertEquals(this.reservationToSave.getPickUpDate(),reservationsDTO.getPickUpDate());
        Assertions.assertEquals(this.reservationToSave.getStatus(),reservationsDTO.getStatus());

    }




}
