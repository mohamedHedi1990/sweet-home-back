package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Country;
@Repository
public interface CountryRepository  extends JpaRepository<Country,Long> {
}
