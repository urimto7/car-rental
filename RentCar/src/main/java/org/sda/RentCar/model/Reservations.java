package org.sda.RentCar.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "pickup_date")
    private String pickupDate;
    @Column(name = "days")
    private int days;
    @Column(name = "status")
    private String status;
    @ManyToOne
  ///  @JoinColumn (name = "id_user", referencedColumnName = "id")
    private User user;
    @ManyToOne
    //@JoinColumn(name = "id_car", referencedColumnName = "id")
    private Car car;

}

