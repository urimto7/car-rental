package org.sda.RentCar.service.impl;

import org.sda.RentCar.converter.CarConverter;
import org.sda.RentCar.converter.UserConverter;
import org.sda.RentCar.dto.CarDTO;
import org.sda.RentCar.exception.NotFoundException;
import org.sda.RentCar.model.Car;
import org.sda.RentCar.model.User;
import org.sda.RentCar.repository.CarRepository;
import org.sda.RentCar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;
    @Override
    public CarDTO add(CarDTO carDTO) {

        Car car= CarConverter.toEntity(carDTO);
        return CarConverter.toDTO( carRepository.save(car));

    }

    @Override
    public void update(CarDTO carDTO) {
        Car existingCar=carRepository.findById(carDTO.getId()).
        orElseThrow(() -> new NotFoundException("Not found"));
        existingCar = CarConverter.toEntityForUpdate(existingCar, carDTO);
        carRepository.save(existingCar);

    }

    @Override
    public void delete(Integer id) {
        Car existingCar=carRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found"));
        carRepository.delete(existingCar);

    }

    @Override
    public CarDTO findById(Integer id) {
        Optional<Car> returnedCar = carRepository.findById(id);
        if (returnedCar.isPresent()) {
            return CarConverter.toDTO(returnedCar.get());
        } else {
            throw new NotFoundException("Car not found");
        }
    }

    @Override
    public List<CarDTO> findAll() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map(c -> CarConverter.toDTO(c)).toList();
    }
    }

