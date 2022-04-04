package org.sweetrooms.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.enumeration.MediaContext;
import org.sweetrooms.persistence.entities.Media;
@Repository
public interface MediaRepository extends JpaRepository<Media,Long> {
	List<Media> findByMediaContext(MediaContext mediaContext);
}
