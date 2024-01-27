package org.sda.RentCar.converter;

import org.sda.RentCar.dto.CarDTO;
import org.sda.RentCar.model.Car;

public class CarConverter {

    public static Car toEntity(CarDTO carDTO){
        Car car=new Car();
        car.setModel(carDTO.getModel());
        car.setBody_type(carDTO.getBody_type());
        car.setHp(carDTO.getHp());
        car.setFuel_type(carDTO.getFuel_type());
        car.setBrand(carDTO.getBrand());
        car.setTransmission_type(carDTO.getTransmission_type());
        return car;
    }
    public static CarDTO toDTO(Car car){
        CarDTO carDTO=new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setModel(car.getModel());
        carDTO.setHp(car.getHp());
        carDTO.setBrand(car.getBrand());
        carDTO.setFuel_type(car.getFuel_type());
        carDTO.setBody_type(car.getBody_type());
        carDTO.setTransmission_type(car.getTransmission_type());
        return carDTO;
    }
    public static Car toEntityForUpdate(Car car,CarDTO carDTO){
        car.setHp(carDTO.getHp());
        return car;
    }
}
