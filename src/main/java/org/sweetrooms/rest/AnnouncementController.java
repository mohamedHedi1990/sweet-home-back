package org.sweetrooms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sweetrooms.business.services.AnnouncementService;
import org.sweetrooms.client.dtos.request.AnnouncementRequest;
import org.sweetrooms.dtos.AnnouncementSearchCriteria;
import org.sweetrooms.persistence.entities.Announcement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@RequestMapping("/announcement")
@Tag(description = "Restfull APIs for announcement",name = "announcement ressource")
public class AnnouncementController {
    @Autowired
    AnnouncementService announcementService;

    @Operation(summary = "Get announcement",
            description = "Provides all available announcements list")
    @GetMapping("")
    public List<Announcement> getAllAnnouncements() {
        return this.announcementService.getAllAnnouncements();
    }

    @Operation(summary = "Get announcement",
            description = "Get announcement by ID")
    @GetMapping("/{id}")
    public Announcement getAnnouncementById(@PathVariable(name = "id") Long id) {
        return this.announcementService.getAnnouncementById(id);
    }

    @Operation(summary = "save announcement",
            description = "save a new announcement")
    @PostMapping("")
    public Announcement saveAnnouncement(@RequestParam("ownerId") Long ownerId, @RequestBody AnnouncementRequest announcement) {
        return this.announcementService.saveAnnouncement(announcement, ownerId);
    }

    @Operation(summary = "delete announcement",
            description = "delete announcement by specific ID")
    @DeleteMapping("/{id}")
    public void deleteAnnouncement(@PathVariable(name = "id") Long id) {
        this.announcementService.deleteAnnouncement(id);
    }

    @GetMapping("/search")
    public List<Announcement> findAnnouncementsByCriteria(@RequestBody AnnouncementSearchCriteria announcementSearchCriteria) {
        return this.announcementService.findAnnouncementsByCriteria(announcementSearchCriteria);
    }
}
