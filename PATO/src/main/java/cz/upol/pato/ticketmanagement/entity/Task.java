package cz.upol.pato.ticketmanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Task {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(fetch= FetchType.LAZY)
    private Ticket ticket;

    private String description;

    private boolean done;
}
