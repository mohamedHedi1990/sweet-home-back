package org.sweetrooms.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.mappers.ReservationMapper;
import org.sweetrooms.business.services.AnnouncementService;
import org.sweetrooms.business.services.LodgerService;
import org.sweetrooms.business.services.ReservationService;
import org.sweetrooms.client.dtos.request.ReservationRequest;
import org.sweetrooms.client.dtos.response.ReservationDetailsResponse;
import org.sweetrooms.enumeration.ReservationStatus;
import org.sweetrooms.persistence.entities.Lodger;
import org.sweetrooms.persistence.entities.Owner;
import org.sweetrooms.persistence.entities.Reservation;
import org.sweetrooms.persistence.entities.User;
import org.sweetrooms.persistence.repositories.UserRepository;
import org.sweetrooms.utils.SecurityUtil;

//import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@RequestMapping("/reservation")
@Tag(description = "Restfull APIs for Reservation", name = "Reservation ressource")
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	@Autowired
	AnnouncementService announcementService;
	@Autowired
	LodgerService lodgerService;
	@Autowired
    UserRepository userRepository;

	@Operation(summary = "Get reservations", description = "Provides all available reservation list")
	@GetMapping("")
	public ResponseEntity<List<Reservation>> getAllReservations(@RequestParam("announcementId") Long announcementId) {
		//Lodger user = lodgerService.getLodgerById(SecurityUtil.getCurrentUserId());
        User user=userRepository.findById(SecurityUtil.getCurrentUserId()).get();
		Owner owner = this.announcementService.getAnnouncementById(announcementId).getAnnouncementOwnerPublished();
		if(owner.getUserId() != user.getUserId())
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		return ResponseEntity.ok(this.reservationService.getAllReservations());
		
	}

	@Operation(summary = "Get reservations", description = "Provides all available reservation list to the corresponding announcement")
	@GetMapping("/by-announcement-id")
	public ResponseEntity<List<ReservationDetailsResponse>> getAllReservationsByAnnouncement(@RequestParam("announcementId") Long announcementId) {
		boolean isAutorized=this.reservationService.isAuthorizedOwner(announcementId);
		if(!isAutorized)
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();


		List<ReservationDetailsResponse> responses= this.reservationService.getReservationsAnnouncement(announcementId);
		return ResponseEntity.ok(responses);

	}

	/*
	 * @Operation(summary = "Get My reservations", description =
	 * "Provides  reservation list of Connected User")
	 * 
	 * @GetMapping("my-reservations") public List<Reservation> getMyReservations() {
	 * return this.reservationService.getMyReservations() ; }
	 */
	@Operation(summary = "Get reservation", description = "Provides reservation by ID")
	@GetMapping("/{id}")
	public Reservation getReservationById(@PathVariable(name = "id") Long id) {
		return this.reservationService.getReservationById(id);
	}

	@Operation(summary = "save reservation", description = "Save new reservation")
	@PostMapping("")
	public Reservation saveReservation(@RequestBody Reservation reservation) {
		return this.reservationService.saveReservation(reservation);
	}

	@Operation(summary = "Delete reservation", description = "Delete reservation by ID")
	@DeleteMapping("/{id}")
	public void deleteReservation(@PathVariable(name = "id") Long id) {
		this.reservationService.deleteReservation(id);
	}

	@Operation(summary = "book a reservation", description = "book new reservation")
	@PostMapping("/book-reservation")
	public ResponseEntity<Void> saveReservation(@RequestParam("announcementId") Long announcementId,
			@RequestBody ReservationRequest reservationIn) {
		Lodger user = lodgerService.getLodgerById(SecurityUtil.getCurrentUserId());

		this.reservationService.saveReservation(reservationIn, announcementId);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/validate")
    public void validateReservation(@RequestBody Long id){
		Reservation reservation=this.reservationService.getReservationById(id);
		reservation.setReservationStatus(ReservationStatus.ACCEPTED);

		this.reservationService.saveReservation(reservation);

	}

}
