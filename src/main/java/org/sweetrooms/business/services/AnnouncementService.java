package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.sweetrooms.dtos.AnnouncementSearchCriteria;
import org.sweetrooms.persistence.entities.Announcement;
import org.sweetrooms.persistence.repositories.AnnouncementRepository;

import java.util.List;

@Service
public class AnnouncementService {
    @Autowired
    AnnouncementRepository announcementRepository;

    public List<Announcement> getAllAnnouncements()
    {

        return this.announcementRepository.findAll();
    }

    public Announcement getAnnouncementById(Long id)
    {
        return this.announcementRepository.getById(id);
    }
    public Announcement saveAnnouncement(Announcement announcement)
    {
        return this.announcementRepository.save(announcement);
    }
    public void deleteAnnouncement(Long id)
    {
        this.announcementRepository.deleteById(id);
    }
    public List<Announcement> findAnnouncementsByCriteria(AnnouncementSearchCriteria announcementSearchCriteria){
          return this.announcementRepository.findAllByAnnouncementAddressAddressCountryCountryLabelContainingAndAnnouncementFirstAvailableDateGreaterThanEqualAndAnnouncementEndAvailableDateLessThanEqualAndAnnouncementGuestNumberEquals(announcementSearchCriteria.getAnnouncementCountryLabel(),announcementSearchCriteria.getAnnouncementStartDate(),announcementSearchCriteria.getAnnouncementEndDate(),announcementSearchCriteria.getNbGuest());
    }
}
