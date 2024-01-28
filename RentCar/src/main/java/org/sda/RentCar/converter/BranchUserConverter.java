package org.sda.RentCar.converter;

import org.sda.RentCar.dto.BranchUserDTO;
import org.sda.RentCar.model.Branch;
import org.sda.RentCar.model.BranchUser;
import org.sda.RentCar.model.User;

public class BranchUserConverter {
    public static BranchUser toEntity(BranchUserDTO branchUserDTO, User user, Branch branch) {
        BranchUser branchUser= new BranchUser();
        branchUser.setUser(user);
        branchUser.setBranch(branch);
        return branchUser;
        }
        public static BranchUserDTO toDTO( BranchUser branchUser){
        BranchUserDTO branchUserDTO=new BranchUserDTO();
        branchUserDTO.setId(branchUser.getId());
        branchUserDTO.setUserDTO(UserConverter.toDTO(branchUser.getUser()));
        branchUserDTO.setBranchDTO(BranchConverter.toDTO(branchUser.getBranch()));
        return branchUserDTO;
        }
}
