package org.sweetrooms.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Lodger;
import org.sweetrooms.persistence.entities.Reservation;
@Repository
public interface ReservationRepository  extends JpaRepository<Reservation,Long> {
List<Reservation> findByReservationLodger(Lodger reservationLodger);

        List<Reservation> findAllByReservationAnnouncmeentAnnouncementId(Long announcementId);
}
