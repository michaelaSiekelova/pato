package cz.upol.pato.historymanagement.repository;

import cz.upol.pato.historymanagement.entity.Event;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Event, Long> {
}
