package org.sda.RentCar.converter;

import org.sda.RentCar.dto.ReservationsDTO;
import org.sda.RentCar.model.Car;
import org.sda.RentCar.model.Reservations;
import org.sda.RentCar.model.User;

public class ReservationsConverter {

    public static Reservations toEntity(ReservationsDTO reservationDTO, User user, Car car) {
        Reservations reservation = new Reservations();
        reservation.setUsername(reservationDTO.getUsername());
        reservation.setPickupDate(reservationDTO.getPickUpDate());
        reservation.setDays(reservationDTO.getDays());
        reservation.setStatus(reservationDTO.getStatus());
        reservation.setUser(user);
        reservation.setCar(car);
        return reservation;
    }
    public static ReservationsDTO toDTO(Reservations reservation) {
        ReservationsDTO reservationDTO = new ReservationsDTO();
        reservationDTO.setIdReservation(null != reservation.getId() ? reservation.getId() : 0);
        reservationDTO.setUsername(reservation.getUsername());
        reservationDTO.setPickUpDate(reservation.getPickupDate());
        reservationDTO.setDays(reservation.getDays());
        reservationDTO.setStatus(reservation.getStatus());
        reservationDTO.setUserDTO(UserConverter.toDTO(reservation.getUser()));
        reservationDTO.setCarDTO(CarConverter.toDTO(reservation.getCar()));
        return reservationDTO;
    }
    public static Reservations toEntityForUpdate (Reservations reservation, ReservationsDTO reservationDTO) {
        reservation.setPickupDate(reservationDTO.getPickUpDate());
        reservation.setDays(reservationDTO.getDays());
        reservation.setStatus(reservationDTO.getStatus());


        return reservation;
    }

}
