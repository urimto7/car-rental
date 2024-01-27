package org.sda.RentCar.dto;

import lombok.Data;

@Data
public class ReservationsDTO {
    private int idReservation;

    private String username;

    private String pickUpDate;

    private int days;

    private String status;

    private UserDTO userDTO;

    private CarDTO carDTO;

}


