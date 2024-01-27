package org.sda.RentCar.controller;

import org.sda.RentCar.dto.CarDTO;
import org.sda.RentCar.dto.UserDTO;
import org.sda.RentCar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")

public class CarController {
    @Autowired
    private CarService carService;
    @PostMapping

    public void add(@RequestBody CarDTO carDTO){
        carService.add(carDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> findById (@PathVariable Integer id ){
        return ResponseEntity.ok(carService.findById(id));
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id ,@RequestBody CarDTO carDTO){
        carService.update(carDTO);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        carService.delete(id);
    }
    @GetMapping
    public ResponseEntity<List<CarDTO>> findAll(){
        return ResponseEntity.ok(carService.findAll());
    }
}
