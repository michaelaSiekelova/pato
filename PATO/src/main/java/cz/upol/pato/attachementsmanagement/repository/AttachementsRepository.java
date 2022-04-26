package cz.upol.pato.attachementsmanagement.repository;

import cz.upol.pato.attachementsmanagement.entity.Attachement;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachementsRepository extends JpaRepository<Attachement, Long> {
}
