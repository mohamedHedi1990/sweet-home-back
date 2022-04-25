package org.sweetrooms.persistence.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Announcement;
import org.sweetrooms.persistence.entities.Lodger;
import org.sweetrooms.persistence.entities.Owner;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {
    List<Announcement> findAllByAnnouncementAddressAddressCityCityLabelContainingAndAnnouncementFirstAvailableDateGreaterThanEqualAndAnnouncementEndAvailableDateLessThanEqualAndAnnouncementGuestNumberEquals(String labelCountry, Date startDate, Date endDate, Integer nbGuest);
    List<Announcement> findTop12ByOrderByCreatedAtDesc();
    public List<Announcement> findByAnnouncementOwnerPublished(Owner owner);
    public List<Announcement> findByAnnouncementLodgerInteracted(Lodger lodger);
}
