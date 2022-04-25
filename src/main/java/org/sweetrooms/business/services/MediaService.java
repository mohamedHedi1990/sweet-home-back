package org.sweetrooms.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.sweetrooms.business.services.files.DBFileStorageService;
import org.sweetrooms.enumeration.MediaContext;
import org.sweetrooms.persistence.entities.Media;
import org.sweetrooms.persistence.repositories.MediaRepository;

@Service
public class MediaService {
    @Autowired
    MediaRepository mediaRepository;

    @Autowired
    private DBFileStorageService dBFileStorageService;

    public List<Media> getAllMedias() {
        return this.mediaRepository.findAll();
    }

    public Media getMediaById(Long id) {
        return this.mediaRepository.getById(id);
    }

    public Media saveMedia(Media media) {
        return this.mediaRepository.save(media);
    }

    public void deleteMedia(Long id) {
        this.mediaRepository.deleteById(id);
    }

    public Media saveMedia(MultipartFile file, MediaContext context) throws Exception {

        String mediaName = dBFileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/file/downloadFile/")
                .path(mediaName).toUriString();

        Media media = new Media();
        media.setMediaContext(context);
        media.setMediaUrl(fileDownloadUri);
        media.setMediaLabel(mediaName);
        media.setMediaSize(file.getSize());
        media.setMediaContentType(file.getContentType());
        media = mediaRepository.save(media);
        return media;
    }
}
