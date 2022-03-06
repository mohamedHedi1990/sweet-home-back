package org.sweetrooms.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.AnnouncementService;
import org.sweetrooms.business.services.EquipementService;
import org.sweetrooms.persistence.entities.Announcement;
import org.sweetrooms.persistence.entities.Equipement;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/annoncement")
@Api(value = "Restfull APIs for annoncement")
public class AnnouncementController {
    @Autowired
    AnnouncementService announcementService;
    @GetMapping("")
    public List<Announcement> getAllAnnouncements()
    {
        return this.announcementService.getAllAnnouncements();
    }
    @GetMapping("/{id}")
    public Announcement getAnnouncementById(@PathVariable(name = "id") Long id)
    {
        return this.announcementService.getAnnouncementById(id);
    }
    @PostMapping("")
    public Announcement saveAnnouncement(Announcement announcement )
    {
        return this.announcementService.saveAnnouncement(announcement);
    }
    @DeleteMapping("/{id}")
    public void deleteAnnouncement(@PathVariable(name = "id")Long id)
    {
        this.announcementService.deleteAnnouncement(id);
    }
}
