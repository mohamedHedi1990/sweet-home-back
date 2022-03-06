package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Reservation;
@Repository
public interface ReservationRepository  extends JpaRepository<Reservation,Long> {
}
