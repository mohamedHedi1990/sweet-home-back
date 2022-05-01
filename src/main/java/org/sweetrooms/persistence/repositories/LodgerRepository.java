package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.Lodger;
@Repository
public interface LodgerRepository  extends JpaRepository<Lodger,Long> {
	public Lodger findByUserEmail(String email);
}
