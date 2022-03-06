package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.persistence.entities.Media;
import org.sweetrooms.persistence.repositories.MediaRepository;

import java.util.List;

@Service
public class MediaService {
    @Autowired
    MediaRepository mediaRepository;

    public List<Media> getAllMedias()
    {
        return this.mediaRepository.findAll();
    }

    public Media getMediaById(Long id)
    {
        return this.mediaRepository.getById(id);
    }
    public Media saveMedia(Media media)
    {
        return this.mediaRepository.save(media);
    }
    public void deleteMedia(Long id)
    {
        this.mediaRepository.deleteById(id);
    }
}
