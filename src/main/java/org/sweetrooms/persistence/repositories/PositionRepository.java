package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Position;
@Repository
public interface PositionRepository extends JpaRepository<Position,Long> {
}
