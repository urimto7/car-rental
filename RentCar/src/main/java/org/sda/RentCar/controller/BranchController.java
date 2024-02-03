package org.sda.RentCar.controller;

import org.sda.RentCar.dto.BranchDTO;
import org.sda.RentCar.service.BranchService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/branch")


public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping
    public void add(@RequestBody BranchDTO branchDTO) {
        branchService.add(branchDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(branchService.findById(id));
    }

    @PutMapping
    public void update(@RequestBody BranchDTO branchDTO) {
        branchService.update(branchDTO);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        branchService.delete (id);}

    @GetMapping
    public ResponseEntity<List<BranchDTO>> findAll() {
        return ResponseEntity.ok(branchService.findAll());
    }




}
