package org.sweetrooms.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.AnnouncementService;
import org.sweetrooms.client.dtos.request.AnnouncementRequest;
import org.sweetrooms.client.dtos.request.AnnouncementUpdateRequest;
import org.sweetrooms.client.dtos.request.SearchAnnouncementRequest;
import org.sweetrooms.client.dtos.response.AnnouncementDetailsResponse;
import org.sweetrooms.client.dtos.response.AnnouncementResponse;
import org.sweetrooms.client.dtos.response.MyAnnouncementResponse;
import org.sweetrooms.client.dtos.response.SearchAnnouncementResponse;
import org.sweetrooms.dtos.AnnouncementSearchCriteria;
import org.sweetrooms.persistence.entities.Announcement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@RequestMapping("/announcement")
@Tag(description = "Restfull APIs for announcement", name = "announcement ressource")
public class AnnouncementController {
	@Autowired
	AnnouncementService announcementService;

	@Operation(summary = "Get announcement", description = "Provides all available announcements list")
	@GetMapping("")
	public List<Announcement> getAllAnnouncements() {
		return this.announcementService.getAllAnnouncements();
	}

	@Operation(summary = "Get announcement", description = "Get announcement by ID")
	@GetMapping("/{id}")
	public Announcement getAnnouncementById(@PathVariable(name = "id") Long id) {
		return this.announcementService.getAnnouncementById(id);
	}
	@Operation(summary = "Get announcement", description = "Get announcement by ID")
	@GetMapping("/details/{id}")
	public AnnouncementDetailsResponse getAnnouncementDetailsById(@PathVariable(name = "id") Long id) {
		return this.announcementService.getAnnouncementDetailsById(id);
	}

	@Operation(summary = "save announcement", description = "save a new announcement")
	@PostMapping("")
	@PreAuthorize("hasAnyAuthority({'OWNER'})")
	public Announcement saveAnnouncement(
			@RequestBody AnnouncementRequest announcement) {
		return this.announcementService.saveAnnouncement(announcement);
	}

	@Operation(summary = "save announcement", description = "save a new announcement")
	@PutMapping("")
	@PreAuthorize("hasAnyAuthority({'OWNER'})")
	public Announcement updateAnnouncement(
			@RequestBody AnnouncementUpdateRequest announcement) {
		return this.announcementService.updateAnnouncement(announcement);
	}

	@Operation(summary = "delete announcement", description = "delete announcement by specific ID")
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyAuthority({'OWNER'})")
	public void deleteAnnouncement(@PathVariable(name = "id") Long id) {
		this.announcementService.deleteAnnouncement(id);
	}

	@PostMapping("/search")
	public List<AnnouncementResponse> findAnnouncementsByCriteria(
			@RequestBody AnnouncementSearchCriteria announcementSearchCriteria) {
		return this.announcementService.findAnnouncementsByCriteria(announcementSearchCriteria);
	}
	
	@GetMapping("/last-published")
	public List<AnnouncementResponse> findLastAnnouncements() {
		return this.announcementService.findLastAnnouncements();
	}
	@GetMapping("/my-announcements")
	public List<MyAnnouncementResponse> findMyAnnouncements() {
		return this.announcementService.getMyAnnoucements();
	}

	@PostMapping("/search-announcement")
	public SearchAnnouncementResponse searchByAnnouncementRequest(
			@RequestBody SearchAnnouncementRequest announcementRequest) {
		return this.announcementService.searchByAnnouncementRequest(announcementRequest);
	}
}
