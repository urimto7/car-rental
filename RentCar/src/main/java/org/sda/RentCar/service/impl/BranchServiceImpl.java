package org.sda.RentCar.service.impl;

import org.sda.RentCar.converter.BranchConverter;
import org.sda.RentCar.dto.BranchDTO;
import org.sda.RentCar.exception.NotFoundException;
import org.sda.RentCar.exception.NotAllowedException;
import org.sda.RentCar.model.Branch;
import org.sda.RentCar.repository.BranchRepository;
import org.sda.RentCar.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service


public class BranchServiceImpl implements BranchService {


    @Autowired
    private BranchRepository branchRepository;

    @Override
    public void add(BranchDTO branchDTO) {

        if (!branchRepository.findById(branchDTO.getId()).isEmpty()) {
            throw new NotAllowedException("this Idbranch does not exist");

        }
        Branch branch = BranchConverter.toEntity(branchDTO);
        branchRepository.save(branch);

    }

    @Override
    public void update(BranchDTO branchDTO) {


        if (!branchRepository.findById(branchDTO.getId()).isEmpty()) {
            throw new NotAllowedException("this Idbranch alredy exist");

        }
        Branch existingBrunch = branchRepository.findById(branchDTO.getId())
                .orElseThrow(() -> new NotFoundException("not found"));
        existingBrunch = BranchConverter.toEntityForUpdate(existingBrunch, branchDTO);
        branchRepository.save(existingBrunch);

    }

    @Override
    public void delete(Integer id) {
        Branch existingBranch = branchRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("not found"));
        branchRepository.delete(existingBranch);
    }

    @Override
    public BranchDTO findById(Integer id) {
        Optional<Branch> returnedBrunch = branchRepository.findById(id);
        if (returnedBrunch.isPresent()) {
            return BranchConverter.toDTO(returnedBrunch.get());
        } else {
            throw new NotFoundException("branch not found");
        }
    }

    @Override
    public List<BranchDTO> findAll() {
        List<Branch> branches = branchRepository.findAll();
        return branches.stream().map(b -> BranchConverter.toDTO(b)).toList();
    }
}

