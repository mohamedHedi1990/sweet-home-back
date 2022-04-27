package org.sweetrooms.client.dtos.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {
	 private Date reservationStartDate;
	 private Date reservationEndDate;
	 private Integer reservationGuestNumber;
	 private long reservationAnnouncmeentID;

}
