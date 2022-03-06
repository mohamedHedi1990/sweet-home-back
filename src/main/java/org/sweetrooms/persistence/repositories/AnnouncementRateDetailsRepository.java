package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.AnnouncementRateDetails;

@Repository
public interface AnnouncementRateDetailsRepository extends JpaRepository<AnnouncementRateDetails,Long> {
}
