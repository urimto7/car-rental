package org.sda.RentCar.controller;

import org.sda.RentCar.dto.UserDTO;
import org.sda.RentCar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public void add(@RequestBody UserDTO userDTO){
        userService.add(userDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.findById(id));

    }
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody UserDTO userDTO){
        userService.update(userDTO);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        userService.delete(id);
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }



}
