package cz.upol.pato.commentsmanagement.repository;

import cz.upol.pato.commentsmanagement.entity.Comment;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
}
