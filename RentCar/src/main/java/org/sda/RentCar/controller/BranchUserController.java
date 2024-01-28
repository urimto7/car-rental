package org.sda.RentCar.controller;

import org.sda.RentCar.dto.BranchUserDTO;
import org.sda.RentCar.model.BranchUser;
import org.sda.RentCar.service.BranchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branchUser")
public class BranchUserController {
    @Autowired
    private BranchUserService branchUserService;
    @GetMapping("/branch/{id}")
    public ResponseEntity<List<BranchUser>> findAllUsersByBranchId(@PathVariable Integer id){
        return ResponseEntity.ok(branchUserService.findAllUsersByBranchId(id));
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<BranchUser>> findAllBranchByUserId(@PathVariable Integer id){
        return ResponseEntity.ok(branchUserService.findAllBranchByUserId(id));
    }
    @PostMapping
    public void add(@RequestBody BranchUserDTO branchUserDTO){
        branchUserService.add(branchUserDTO);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        branchUserService.delete(id);
    }

}
