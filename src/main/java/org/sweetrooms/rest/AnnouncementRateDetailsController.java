package org.sweetrooms.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.AnnouncementRateDetailsService;
import org.sweetrooms.persistence.entities.AnnouncementRateDetails;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/annoncement_rate_details")
@Api(value = "Restfull APIs for Address")
public class AnnouncementRateDetailsController {
    @Autowired
    AnnouncementRateDetailsService announcementRateDetailsService;
    @GetMapping("")
    public List<AnnouncementRateDetails> getAllAnnouncementRateDetails()
    {
        return this.announcementRateDetailsService.getAllAnnouncementRateDetails();
    }
    @GetMapping("/{id}")
    public AnnouncementRateDetails getAnnouncementRateDetailsById(@PathVariable(name = "id") Long id)
    {
        return this.announcementRateDetailsService.getAnnouncementRateDetailsById(id);
    }
    @PostMapping("")
    public AnnouncementRateDetails saveAnnouncementRateDetails(AnnouncementRateDetails announcementRateDetails )
    {
        return this.announcementRateDetailsService.saveAnnouncementRateDetails(announcementRateDetails);
    }
    @DeleteMapping("/{id}")
    public void deleteAnnouncementRateDetails(@PathVariable(name = "id")Long id)
    {
        this.announcementRateDetailsService.deleteAnnouncementRateDetails(id);
    }
}
