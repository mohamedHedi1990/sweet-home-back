package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Owner;
@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {
	Owner findByUserId(Long userId);
}
