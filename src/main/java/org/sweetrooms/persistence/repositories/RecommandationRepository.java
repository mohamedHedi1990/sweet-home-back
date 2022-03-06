package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Recommandation;

@Repository
public interface RecommandationRepository extends JpaRepository<Recommandation,Long> {
}
