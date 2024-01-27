package org.sda.RentCar.controller;

import org.sda.RentCar.dto.ReservationsDTO;
import org.sda.RentCar.service.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationsController {
    @Autowired
    private ReservationsService reservationsService;

    @PostMapping
    public void add(@RequestBody ReservationsDTO reservationsDTO) {
        reservationsService.add(reservationsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationsDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(reservationsService.findById(id));
    }

    @PutMapping
    public void update(@RequestBody ReservationsDTO reservationsDTO) {
        reservationsService.update(reservationsDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        reservationsService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<ReservationsDTO>> findAll() {
        return ResponseEntity.ok(reservationsService.findAll());
    }
}
