package cz.upol.pato.attributesmanagement.repository;

import cz.upol.pato.attributesmanagement.entity.AttributeValue;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeValueRepository  extends JpaRepository<AttributeValue, Long> {
    List<AttributeValue> findByTicket(Ticket ticket);
}
