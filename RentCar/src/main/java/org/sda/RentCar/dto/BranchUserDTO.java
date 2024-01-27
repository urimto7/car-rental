package org.sda.RentCar.dto;


import lombok.Data;

import org.sda.RentCar.model.User;
@Data

public class BranchUserDTO {
    private int id;
    private UserDTO userDTO;
    private BranchDTO branchDTO;
}
