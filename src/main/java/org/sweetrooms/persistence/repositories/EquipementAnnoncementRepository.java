package org.sweetrooms.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Announcement;
import org.sweetrooms.persistence.entities.EquipementAnnoncement;
@Repository
public interface EquipementAnnoncementRepository  extends JpaRepository<EquipementAnnoncement,Long> {
	List<EquipementAnnoncement> findByAnnouncement(Announcement announcement);
}
