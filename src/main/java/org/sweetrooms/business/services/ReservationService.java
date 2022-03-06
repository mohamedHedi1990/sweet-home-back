package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.persistence.entities.Reservation;
import org.sweetrooms.persistence.repositories.ReservationRepository;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations()
    {
        return this.reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id)
    {
        return this.reservationRepository.getById(id);
    }
    public Reservation saveReservation(Reservation reservation)
    {
        return this.reservationRepository.save(reservation);
    }
    public void deleteReservation(Long id)
    {
        this.reservationRepository.deleteById(id);
    }
}
