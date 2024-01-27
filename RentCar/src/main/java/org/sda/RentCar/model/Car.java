package org.sda.RentCar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car")
    private Integer id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "hp")
    private Integer hp;
    @Column(name = "body_type")
   private String body_type;
    @Column(name = "fuel_type")
    private String fuel_type;
    @Column(name = "transmission_type")
    private String transmission_type;



}
