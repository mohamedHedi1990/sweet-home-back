package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Announcement;
@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {
}
