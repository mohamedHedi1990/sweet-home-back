package org.sweetrooms.business.mappers;

import org.sweetrooms.client.dtos.response.ReservationDetailsResponse;
import org.sweetrooms.persistence.entities.Reservation;

public class ReservationMapper {

    public static ReservationDetailsResponse toReservationDetailsResponse(Reservation reservation){
        return new ReservationDetailsResponse(reservation.getReservationId(), reservation.getReservationStartDate(),
                reservation.getReservationEndDate(), reservation.getReservationGuestNumber(),
                reservation.getReservationStatus(), UserMapper.toUserDto(reservation.getReservationUser()), reservation.getReservationAnnouncmeent());
    }

}
