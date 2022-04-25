package org.sweetrooms.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.persistence.entities.Lodger;
import org.sweetrooms.persistence.entities.Owner;
import org.sweetrooms.persistence.entities.Reservation;
import org.sweetrooms.persistence.entities.User;
import org.sweetrooms.persistence.repositories.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    UserService userService;
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
    public List<Reservation> getMyReservations()
    {
    	
		User user=userService.getConnectedUser();
		if(user instanceof Lodger lodger)return this.reservationRepository.findByReservationLodger(lodger);
		else {
			return this.reservationRepository.findByReservationOwner
					(((Owner)user));
		}
    }
}
