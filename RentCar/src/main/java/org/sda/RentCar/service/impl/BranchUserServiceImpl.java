package org.sda.RentCar.service.impl;


import org.sda.RentCar.converter.BranchUserConverter;
import org.sda.RentCar.converter.UserConverter;
import org.sda.RentCar.dto.BranchUserDTO;
import org.sda.RentCar.exception.NotAllowedException;
import org.sda.RentCar.exception.NotFoundException;
import org.sda.RentCar.model.Branch;
import org.sda.RentCar.model.BranchUser;
import org.sda.RentCar.model.User;
import org.sda.RentCar.repository.BranchRepository;
import org.sda.RentCar.repository.BranchUserRepository;
import org.sda.RentCar.repository.CarRepository;
import org.sda.RentCar.repository.UserRepository;
import org.sda.RentCar.service.BranchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class BranchUserServiceImpl implements BranchUserService {
    @Autowired
    private BranchUserRepository branchUserRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BranchRepository branchRepository;

    @Override
    public List<BranchUser> findAllUsersByBranchId(Integer id) {

        // TODO kontorllo nqs branchi ekziston apo jo parapprakisht
        // TODO nqs jo jep errorin perkates


        List<BranchUser> branchUser = branchUserRepository.findAllUsersByBranchId(id);
        if (branchUser.isEmpty()){
            throw new RuntimeException("There are no users associated with this branch");
        }
        return branchUser;
    }

    @Override
    public List<BranchUser> findAllBranchByUserId(Integer id) {
        List<BranchUser> branchUser= branchUserRepository.findAllBranchByUserId(id);
        if( branchUser.isEmpty()){
            throw new RuntimeException("There are no branches associated with this user");
        } return branchUser;
    }

    @Override
    public void add(BranchUserDTO branchUserDTO) {

        User user= userRepository.findById(branchUserDTO.getUserDTO().getId()).orElseThrow();
        Branch branch= branchRepository.findById(branchUserDTO.getBranchDTO().getId()).orElseThrow();
        BranchUser branchUser= BranchUserConverter.toEntity(branchUserDTO,user,branch);
        branchUserRepository.save(branchUser);
    }

    @Override
    public void delete(Integer id) {
        BranchUser existingBranch = branchUserRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found"));
        branchUserRepository.delete(existingBranch);

    }

}
