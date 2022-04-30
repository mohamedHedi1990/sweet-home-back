package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.PasswordResetToken;

@Repository
public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken,Long> {

	PasswordResetToken findByToken(String token);

}
