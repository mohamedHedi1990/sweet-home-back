package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.enumeration.RoleCode;
import org.sweetrooms.persistence.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
	Role findByRoleCode(RoleCode roleCode);
}
