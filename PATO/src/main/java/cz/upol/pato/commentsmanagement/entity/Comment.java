package cz.upol.pato.commentsmanagement.entity;

import cz.upol.pato.ticketmanagement.entity.Ticket;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue
    private long id;

    private String content;

    @ManyToOne(fetch=FetchType.LAZY)
    private Ticket ticket;
}
