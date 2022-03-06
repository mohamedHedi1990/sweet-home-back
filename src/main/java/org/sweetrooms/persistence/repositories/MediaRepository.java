package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Media;
@Repository
public interface MediaRepository extends JpaRepository<Media,Long> {
}
