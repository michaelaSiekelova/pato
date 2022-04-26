package cz.upol.pato.attachementsmanagement.entity;

import cz.upol.pato.ticketmanagement.entity.Ticket;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Attachement {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    private Ticket ticket;

    @Lob
    @Basic(fetch=FetchType.LAZY)
    protected byte[] file;


}
