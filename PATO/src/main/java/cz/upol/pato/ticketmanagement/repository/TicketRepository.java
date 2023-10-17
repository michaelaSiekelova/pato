package cz.upol.pato.ticketmanagement.repository;

import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import cz.upol.pato.usermanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByCurrentUser(UserEntity currentUser);
    List<Ticket> findByProject(Project project);

}
