package org.sda.RentCar.service;


import org.sda.RentCar.dto.BranchUserDTO;
import org.sda.RentCar.model.BranchUser;

import java.util.List;

public interface BranchUserService {
    List<BranchUser> findAllUsersByBranchId(Integer id);
    List<BranchUser> findAllBranchByUserId(Integer id);
    void add (BranchUserDTO branchUserDTO);
    void delete(Integer id);
}
