package org.sda.RentCar.service;

import org.sda.RentCar.dto.CarDTO;

import java.util.List;

public interface CarService {
    CarDTO add(CarDTO carDTO);
    void update(CarDTO carDTO);
    void delete(Integer id);
    CarDTO findById(Integer id);
    List<CarDTO> findAll();
}
