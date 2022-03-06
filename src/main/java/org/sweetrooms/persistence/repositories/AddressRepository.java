package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
