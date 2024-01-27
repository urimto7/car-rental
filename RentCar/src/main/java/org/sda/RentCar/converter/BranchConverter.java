package org.sda.RentCar.converter;

import org.sda.RentCar.dto.BranchDTO;
import org.sda.RentCar.model.Branch;

public class BranchConverter {
    public static Branch toEntity(BranchDTO branchDTO) {
        Branch branch = new Branch();
        branch.setAdress(branchDTO.getAdress());
        branch.setCity(branchDTO.getCity());
        return branch;

    }

    public static BranchDTO toDTO(Branch branch) {
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setId(branch.getId());
        branchDTO.setAdress(branch.getAdress());
        branchDTO.setCity(branch.getCity());
         return branchDTO;
    }
    public static Branch toEntityForUpdate(Branch branch, BranchDTO branchDTO){
        branch.setCity(branchDTO.getCity());
        branch.setAdress(branchDTO.getAdress());
        return branch;
    }






}
