package org.sda.RentCar.controller;

import org.sda.RentCar.model.BranchUser;
import org.sda.RentCar.service.BranchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/branchuser")
public class BranchUserController {
    @Autowired
    private BranchUserService branchUserService;
    @GetMapping
    public ResponseEntity<List<BranchUser>> findAllUsersByBranchId(Integer id){
        return ResponseEntity.ok(branchUserService.findAllUsersByBranchId());
    }
    @GetMapping
    public ResponseEntity<List<BranchUser>> findAllBranchByUserId(Integer id){
        return ResponseEntity.ok(branchUserService.findAllBranchByUserId());
    }

}
