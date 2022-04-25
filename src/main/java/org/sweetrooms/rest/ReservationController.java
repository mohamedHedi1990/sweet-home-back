package org.sweetrooms.rest;

//import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.ReservationService;
import org.sweetrooms.persistence.entities.Reservation;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/reservation")
@Tag(description = "Restfull APIs for Reservation",name = "Reservation ressource")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @Operation(summary = "Get reservations",
            description = "Provides all available reservation list")
    @GetMapping("")
    public List<Reservation> getAllReservations()
    {
        return this.reservationService.getAllReservations();
    }
    @Operation(summary = "Get My reservations",
            description = "Provides  reservation list of Connected User")
    @GetMapping("My-Reservations")
    public List<Reservation> getMyReservations()
    {
        return this.reservationService.getMyReservations() ;
    }
    @Operation(summary = "Get reservation",
            description = "Provides reservation by ID")
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable(name = "id") Long id)
    {
        return this.reservationService.getReservationById(id);
    }
    @Operation(summary = "save reservation",
            description = "Save new reservation")
    @PostMapping("")
    public Reservation saveReservation(@RequestBody Reservation reservation)
    {
        return this.reservationService.saveReservation(reservation);
    }
    @Operation(summary = "Delete reservation",
            description = "Delete reservation by ID")
    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable(name = "id")Long id)
    {
        this.reservationService.deleteReservation(id);
    }
    

}
