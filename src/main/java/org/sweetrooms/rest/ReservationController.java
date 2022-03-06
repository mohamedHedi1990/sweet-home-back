package org.sweetrooms.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.ReservationService;
import org.sweetrooms.persistence.entities.Reservation;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/reservation")
@Api(value = "Restfull APIs for reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @GetMapping("")
    public List<Reservation> getAllReservations()
    {
        return this.reservationService.getAllReservations();
    }
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable(name = "id") Long id)
    {
        return this.reservationService.getReservationById(id);
    }
    @PostMapping("")
    public Reservation saveReservation(Reservation reservation)
    {
        return this.reservationService.saveReservation(reservation);
    }
    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable(name = "id")Long id)
    {
        this.reservationService.deleteReservation(id);
    }

}
