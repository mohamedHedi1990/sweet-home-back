package org.sweetrooms.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sweetrooms.enumeration.ReservationStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sweet_rooms_reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    private Integer reservationGuestNumber;
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus ;
    private Date reservationStartDate;
    private Date reservationEndDate;
    @ManyToOne
    private Lodger reservationLodger;
    @ManyToOne
    private Owner reservationOwner;
}
