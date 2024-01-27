package org.sda.RentCar.dto;

import lombok.Data;

@Data

public class CarDTO {

    private Integer id;

    private String brand;

    private String model;

    private Integer hp;

    private String body_type;

    private String fuel_type;

    private String transmission_type;
}
