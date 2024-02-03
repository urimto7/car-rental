package org.sda.RentCar.service.impl;

import org.sda.RentCar.controller.CarController;
import org.sda.RentCar.converter.CarConverter;
import org.sda.RentCar.converter.ReservationsConverter;
import org.sda.RentCar.dto.ReservationsDTO;
import org.sda.RentCar.exception.NotFoundException;
import org.sda.RentCar.model.Reservations;
import org.sda.RentCar.model.User;
import org.sda.RentCar.repository.CarRepository;
import org.sda.RentCar.repository.ReservationsRepository;
import org.sda.RentCar.repository.UserRepository;
import org.sda.RentCar.service.ReservationsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sda.RentCar.model.Car;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ReservationsServiceImpl implements ReservationsService {

    @Autowired
    private ReservationsRepository reservationsRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarRepository carRepository;

    public ReservationsDTO add(ReservationsDTO reservationsDTO) {
        User user = userRepository.findById(reservationsDTO.getUserDTO().getId())
                .orElseThrow(() -> new NotFoundException("User Not found with ID " + reservationsDTO.getUserDTO().getId()));
        Car car = carRepository.findById(reservationsDTO.getUserDTO().getId())
                .orElseThrow(() -> new NotFoundException("User Not found with ID " + reservationsDTO.getUserDTO().getId()));
        Reservations reservations = ReservationsConverter.toEntity(reservationsDTO,user
                ,carRepository.findById(reservationsDTO.getCarDTO().getId())
                .orElseThrow(() -> new NotFoundException("CAR Not found with ID " + reservationsDTO.getCarDTO().getId())));
        reservationsRepository.save(reservations);
        Reservations reservations1= ReservationsConverter.toEntity(reservationsDTO,user,car);
        return ReservationsConverter.toDTO( reservationsRepository.save(reservations1));

    }



    @Override
    public void update(ReservationsDTO reservationDTO) {

        Optional<Reservations> existingReservation = reservationsRepository.findById(reservationDTO.getIdReservation());
        if (existingReservation.isPresent()) {
            Reservations reservationToUpdate = existingReservation.get();
            BeanUtils.copyProperties(reservationDTO, reservationToUpdate);
            reservationsRepository.save(reservationToUpdate);
        } else {
            throw new NotFoundException("Reservation not found");
        }
    }

    @Override
    public void delete(Integer id) {
        Reservations existingReservation = reservationsRepository.findById(id).orElseThrow(() -> new NotFoundException("Reservation not found"));
        reservationsRepository.delete(existingReservation);
    }

    @Override
    public ReservationsDTO findById(Integer id) {
        Optional<Reservations> returnedReservation = reservationsRepository.findById(id);
        if (returnedReservation.isPresent()) {
            return ReservationsConverter.toDTO(returnedReservation.get());
        } else {
            throw new NotFoundException("Reservation with id " + id + " not found");
         }
    }

    @Override
    public List<ReservationsDTO> findAll() {
        List<Reservations> reservations = reservationsRepository.findAll();
        return reservations.stream().map(ReservationsConverter::toDTO).collect(Collectors.toList());
    }
}



