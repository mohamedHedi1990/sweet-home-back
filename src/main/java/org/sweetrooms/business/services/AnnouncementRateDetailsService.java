package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.persistence.entities.AnnouncementRateDetails;
import org.sweetrooms.persistence.repositories.AnnouncementRateDetailsRepository;

import java.util.List;

@Service
public class AnnouncementRateDetailsService {
    @Autowired
    AnnouncementRateDetailsRepository announcementRateDetailsRepository;

    public List<AnnouncementRateDetails> getAllAnnouncementRateDetails()
    {
        return this.announcementRateDetailsRepository.findAll();
    }

    public AnnouncementRateDetails getAnnouncementRateDetailsById(Long id)
    {
        return this.announcementRateDetailsRepository.getById(id);
    }
    public AnnouncementRateDetails saveAnnouncementRateDetails(AnnouncementRateDetails announcementRateDetails)
    {
        return this.announcementRateDetailsRepository.save(announcementRateDetails);
    }
    public void deleteAnnouncementRateDetails(Long id)
    {

        this.announcementRateDetailsRepository.deleteById(id);
    }
}
