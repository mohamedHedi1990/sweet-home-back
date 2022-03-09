package org.sweetrooms.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.AnnouncementService;
import org.sweetrooms.persistence.entities.Announcement;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/annoncement")
@Tag(description = "Restfull APIs for announcement",name = "announcement ressource")
public class AnnouncementController {
    @Autowired
    AnnouncementService announcementService;
    @Operation(summary = "Get announcement",
            description = "Provides all available announcements list")
    @GetMapping("")
    public List<Announcement> getAllAnnouncements()
    {
        return this.announcementService.getAllAnnouncements();
    }
    @Operation(summary = "Get announcement",
            description = "Get announcement by ID")
    @GetMapping("/{id}")
    public Announcement getAnnouncementById(@PathVariable(name = "id") Long id)
    {
        return this.announcementService.getAnnouncementById(id);
    }
    @Operation(summary = "save announcement",
            description = "save a new announcement")
    @PostMapping("")
    public Announcement saveAnnouncement(Announcement announcement )
    {
        return this.announcementService.saveAnnouncement(announcement);
    }
    @Operation(summary = "delete announcement",
            description = "delete announcement by specific ID")
    @DeleteMapping("/{id}")
    public void deleteAnnouncement(@PathVariable(name = "id")Long id)
    {
        this.announcementService.deleteAnnouncement(id);
    }
}
