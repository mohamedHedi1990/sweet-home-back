package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Reduction;

@Repository
public interface ReductionRepository extends JpaRepository<Reduction,Long> {
}
