package org.sweetrooms.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Lodger;
import org.sweetrooms.persistence.entities.Reservation;
import org.sweetrooms.persistence.entities.User;

@Repository
public interface ReservationRepository  extends JpaRepository<Reservation,Long> {
List<Reservation> findByReservationUser(User reservationUser);

        List<Reservation> findAllByReservationAnnouncmeentAnnouncementId(Long announcementId);
}
