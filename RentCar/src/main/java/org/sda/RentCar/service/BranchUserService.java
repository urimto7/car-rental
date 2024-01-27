package org.sda.RentCar.service;


import org.sda.RentCar.model.BranchUser;

import java.util.List;

public interface BranchUserService {
    List<BranchUser> findAllUsersByBranchId();
    List<BranchUser> findAllBranchByUserId();
}
