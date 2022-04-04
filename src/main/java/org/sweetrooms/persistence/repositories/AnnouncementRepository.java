package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.enumeration.AnnouncementType;
import org.sweetrooms.persistence.entities.Announcement;

import java.util.Date;
import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {
    List<Announcement> findAllByAnnouncementAddressAddressCountryCountryLabelContainingAndAnnouncementFirstAvailableDateGreaterThanEqualAndAnnouncementEndAvailableDateLessThanEqualAndAnnouncementGuestNumberEqualsAndAnnouncementType(String labelCountry, Date startDate, Date endDate, Integer nbGuest,
    		AnnouncementType announcementType);

}
