package cz.upol.pato.attributesmanagement.entity;

import cz.upol.pato.attributesmanagement.enums.AttributeType;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class AttributeValue {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch=FetchType.LAZY)
    private Attribute attribute;

    private AttributeType type;

    @ManyToOne(fetch=FetchType.LAZY)
    private Ticket ticket;

    private String string;

    private Integer integer;

    private Boolean bool;

    @Lob
    @Basic(fetch=FetchType.LAZY)
    protected byte[] file;
}
