package org.sweetrooms.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.MediaService;
import org.sweetrooms.persistence.entities.Media;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/media")
@Tag(description = "Restfull APIs for Media",name = "Media ressource")
public class MediaController {
    @Autowired
    MediaService mediaService;
    @Operation(summary = "Get Medias",
            description = "Provides all available medias list")
    @GetMapping("")
    public List<Media> getAllMedias()
    {
        return this.mediaService.getAllMedias();
    }
    @Operation(summary = "Get media",
            description = "Provides a specific media by ID")
    @GetMapping("/{id}")
    public Media getMediaById(@PathVariable(name = "id")Long id)
    {
        return this.mediaService.getMediaById(id);
    }
    @Operation(summary = "save media",
            description = "save a new media")
    @PostMapping("")
    public Media saveMedia(Media media)
    {
        return this.mediaService.saveMedia(media);
    }
    @Operation(summary = "delete ",
            description = "delete a specific media by ID ")
    @DeleteMapping("/{id}")
    public void deleteMedia(@PathVariable(name = "id")Long id)
    {
        this.mediaService.deleteMedia(id);
    }
}
