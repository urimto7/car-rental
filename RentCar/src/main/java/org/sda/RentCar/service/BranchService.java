package org.sda.RentCar.service;

import org.sda.RentCar.dto.BranchDTO;

import java.util.List;

public interface BranchService{
    void add(BranchDTO branchDTO);
    void update(BranchDTO branchDTO);
    void delete(Integer id);
    BranchDTO findById(Integer id);
    List<BranchDTO> findAll();

}