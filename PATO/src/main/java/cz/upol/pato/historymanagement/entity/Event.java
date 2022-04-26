package cz.upol.pato.historymanagement.entity;

import cz.upol.pato.historymanagement.enums.EventType;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Event {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch=FetchType.LAZY)
    private Ticket ticket;

    private EventType type;
}
