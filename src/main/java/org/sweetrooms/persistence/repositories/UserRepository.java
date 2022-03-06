package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
