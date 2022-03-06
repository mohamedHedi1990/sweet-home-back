package org.sweetrooms.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.MediaService;
import org.sweetrooms.business.services.RoleService;
import org.sweetrooms.persistence.entities.Media;
import org.sweetrooms.persistence.entities.Role;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/media")
@Api(value = "Restfull APIs for media")
public class MediaController {
    @Autowired
    MediaService mediaService;
    @GetMapping("")
    public List<Media> getAllMedias()
    {
        return this.mediaService.getAllMedias();
    }
    @GetMapping("/{id}")
    public Media getMediaById(@PathVariable(name = "id")Long id)
    {
        return this.mediaService.getMediaById(id);
    }
    @PostMapping("")
    public Media saveMedia(Media media)
    {
        return this.mediaService.saveMedia(media);
    }
    @DeleteMapping("/{id}")
    public void deleteMedia(@PathVariable(name = "id")Long id)
    {
        this.mediaService.deleteMedia(id);
    }
}
