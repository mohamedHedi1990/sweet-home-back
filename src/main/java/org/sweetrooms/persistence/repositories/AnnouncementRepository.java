package org.sweetrooms.persistence.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Announcement;
import org.sweetrooms.persistence.entities.Lodger;
import org.sweetrooms.persistence.entities.Owner;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {

    List<Announcement> findAllByAnnouncementAddressAddressCityCityLabelContainingAndAnnouncementFirstAvailableDateGreaterThanEqualAndAnnouncementEndAvailableDateLessThanEqualAndAnnouncementGuestNumberEquals(String labelCountry, Date startDate, Date endDate, Integer nbGuest);

    Page<Announcement> findAllByAnnouncementAddressAddressCityCityLabelContainingAndAnnouncementFirstAvailableDateGreaterThanEqualAndAnnouncementEndAvailableDateLessThanEqualAndAnnouncementGuestNumberEquals(String labelCountry, Date startDate, Date endDate, Integer nbGuest, Pageable pageable);
    List<Announcement> findTop12ByOrderByCreatedAtDesc();
    public List<Announcement> findByAnnouncementOwnerPublished(Owner owner);
    public List<Announcement> findByAnnouncementLodgerInteracted(Lodger lodger);

    @Query("select a from Announcement a WHERE (:city is null or a.announcementAddress.addressCity.cityLabel like :city) and (:numGuest is null or a.announcementGuestNumber = :numGuest) " +
            "and (:startDate is null or a.announcementFirstAvailableDate >= :startDate) and (:finDate is null or a.announcementEndAvailableDate <= :finDate)")
    Page<Announcement> findAllByAnnouncementSearchRequest(@Param("city") String city, @Param("numGuest") Integer numGuest,
                                                          @Param("startDate") Date startDate, @Param("finDate") Date finDate, Pageable pageable);


}
