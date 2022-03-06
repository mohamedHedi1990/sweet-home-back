package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Equipement;
@Repository
public interface EquipementRepository  extends JpaRepository<Equipement,Long> {
}
