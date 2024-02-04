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
import org.sda.RentCar.dto.UserDTO;
import org.sda.RentCar.exception.NotAllowedException;
import org.sda.RentCar.model.Car;
import org.sda.RentCar.repository.CarRepository;
import org.sda.RentCar.service.CarService;
import org.sda.RentCar.service.impl.CarServiceImpl;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {
    @Mock
    private CarRepository carRepository;
    @InjectMocks
    private CarServiceImpl carService;

    private CarDTO carToSave;
    private Car car;

    @BeforeEach
    public void setUp(){
        initCar();
        initCarDTO();
    }

    private void initCarDTO(){
        carToSave= new CarDTO();
        carToSave.setModel("X6");
        carToSave.setHp(124);
        carToSave.setTransmission_type("automatic");
        carToSave.setBrand("BMW");
        carToSave.setFuel_type("diesel");
        carToSave.setBody_type("sedan");
    }
    private void initCar(){
        car= new Car();
        car.setModel("X6");
        car.setHp(124);
        car.setTransmission_type("automatic");
        car.setBrand("BMW");
        car.setFuel_type("diesel");
        car.setBody_type("sedan");
    }
@Test
    void saveCarTest_IsOK(){
        Mockito.when(carRepository.save(Mockito.any())).thenReturn(car);
        CarDTO carDTO = carService.add(carToSave);
        Assertions.assertEquals(this.carToSave.getModel(),carDTO.getModel());
        Assertions.assertEquals(this.carToSave.getHp(),carDTO.getHp());
        Assertions.assertEquals(this.carToSave.getBrand(),carDTO.getBrand());
        Assertions.assertEquals(this.carToSave.getTransmission_type(),carDTO.getTransmission_type());
        Assertions.assertEquals(this.carToSave.getFuel_type(),carDTO.getFuel_type());
        Assertions.assertEquals(this.carToSave.getBody_type(),carDTO.getBody_type());

    }

}
