package org.sweetrooms.business.mappers;

import org.sweetrooms.client.dtos.response.ReservationDetailsResponse;
import org.sweetrooms.enumeration.MediaContext;
import org.sweetrooms.persistence.entities.Reservation;

public class ReservationMapper {

    public static ReservationDetailsResponse toReservationDetailsResponse(Reservation reservation){
        return new ReservationDetailsResponse(reservation.getReservationId(), reservation.getReservationLodger().getUserFirstName(),
                reservation.getReservationLodger().getUserLastName(), reservation.getReservationStartDate(),
                reservation.getReservationEndDate(), reservation.getReservationGuestNumber(),
                reservation.getReservationStatus(), reservation.getReservationLodger().getUserMedias().stream().
                filter(media -> media.getMediaContext() == MediaContext.PICTURE_PROFIL)
                .map(media -> media.getMediaUrl()).findFirst().orElse(null));
    }

}
