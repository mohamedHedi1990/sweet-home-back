package org.sweetrooms.business.mappers;

import org.sweetrooms.client.dtos.request.ReservationRequest;
import org.sweetrooms.enumeration.ReservationStatus;
import org.sweetrooms.persistence.entities.Announcement;
import org.sweetrooms.persistence.entities.Lodger;
import org.sweetrooms.persistence.entities.Reservation;

public class ReservationMapper {

	public static Reservation fromReservationRequest(ReservationRequest resRequest, Lodger lodger,
			Announcement announce) {
		return new Reservation(null, resRequest.getReservationGuestNumber(), ReservationStatus.PENDING,
				resRequest.getReservationStartDate(), resRequest.getReservationEndDate(), lodger, announce);
	}
private ReservationMapper()
{
	
}
}
