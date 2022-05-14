package org.sweetrooms.client.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sweetrooms.enumeration.ReservationStatus;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDetailsResponse {


    private Long reservationId;
    private String userFirstName;
    private String userLastName;

    private Date reservationStartDate;
    private Date reservationEndDate;

    private Integer reservationGuestNumber;
    private ReservationStatus reservationStatus ;

    private String userPictureUrl;

}
