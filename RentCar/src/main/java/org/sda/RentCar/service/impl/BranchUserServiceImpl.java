package org.sda.RentCar.service.impl;


import org.sda.RentCar.model.BranchUser;
import org.sda.RentCar.repository.BranchUserRepository;
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

    @Override
    public List<BranchUser> findAllUsersByBranchId() {

        // TODO kontorllo nqs branchi ekziston apo jo parapprakisht
        // TODO nqs jo jep errorin perkates
        List<BranchUser> branchUser = branchUserRepository.findAllUsersByBranchId(id);
        if (branchUser.isEmpty()){
            throw new RuntimeException("There are no users associated with this branch");
        }
        return branchUser;
    }

    @Override
    public List<BranchUser> findAllBranchByUserId() {
        List<BranchUser> branchUser= branchUserRepository.findAllBranchByUserId(id);
        if( branchUser.isEmpty()){
            throw new RuntimeException("There are no branches associated with this user");
        } return branchUser;
    }

}
