package org.sda.RentCar.repository;

import org.sda.RentCar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {

}
