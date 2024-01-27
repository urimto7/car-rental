package org.sda.RentCar.repository;

import org.sda.RentCar.model.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ReservationsRepository extends JpaRepository <Reservations, Integer>  {
    List<Reservations> findAllByUsername(String username);
    ;
    List<Reservations> findAllByStatus(String status);

}
