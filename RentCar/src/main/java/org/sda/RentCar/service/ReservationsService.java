package org.sda.RentCar.service;

import org.sda.RentCar.dto.ReservationsDTO;
import java.util.List;

public interface ReservationsService {


        ReservationsDTO add (ReservationsDTO reservationDTO);
        void update(ReservationsDTO reservationDTO);
        void delete(Integer id);
        ReservationsDTO findById(Integer id);
        List<ReservationsDTO> findAll();
    }

