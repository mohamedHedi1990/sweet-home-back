package org.sweetrooms.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sweetrooms.persistence.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
