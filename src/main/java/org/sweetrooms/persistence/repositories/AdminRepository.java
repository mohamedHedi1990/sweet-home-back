package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
}
