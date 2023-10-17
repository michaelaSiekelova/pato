package cz.upol.pato.ticketmanagement.repository;

import cz.upol.pato.ticketmanagement.entity.Task;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTicket(Ticket ticket);
}
