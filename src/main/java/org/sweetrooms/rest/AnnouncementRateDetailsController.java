package org.sweetrooms.rest;

//import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.AnnouncementRateDetailsService;
import org.sweetrooms.persistence.entities.AnnouncementRateDetails;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/annoncement_rate_details")
@Tag(description = "Restfull APIs for announcement rate details",name = "announcement details ressource")
public class AnnouncementRateDetailsController {
    @Autowired
    AnnouncementRateDetailsService announcementRateDetailsService;
    @Operation(summary = "Get announcement details ",
            description = "Provides all available anouncements details list")
    @GetMapping("")
    public List<AnnouncementRateDetails> getAllAnnouncementRateDetails()
    {
        return this.announcementRateDetailsService.getAllAnnouncementRateDetails();
    }
    @Operation(summary = "Get announcement details",
            description = "Get announcement details by ID")
    @GetMapping("/{id}")
    public AnnouncementRateDetails getAnnouncementRateDetailsById(@PathVariable(name = "id") Long id)
    {
        return this.announcementRateDetailsService.getAnnouncementRateDetailsById(id);
    }
    @Operation(summary = "save announcement details",
            description = "save a new announcement details")
    @PostMapping("")
    public AnnouncementRateDetails saveAnnouncementRateDetails(AnnouncementRateDetails announcementRateDetails )
    {
        return this.announcementRateDetailsService.saveAnnouncementRateDetails(announcementRateDetails);
    }
    @Operation(summary = "delete announcement details",
            description = "delete announcement details by ID")
    @DeleteMapping("/{id}")
    public void deleteAnnouncementRateDetails(@PathVariable(name = "id")Long id)
    {
        this.announcementRateDetailsService.deleteAnnouncementRateDetails(id);
    }
}
