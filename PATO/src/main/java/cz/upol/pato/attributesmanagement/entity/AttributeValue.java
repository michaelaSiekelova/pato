package cz.upol.pato.attributesmanagement.entity;

import cz.upol.pato.attributesmanagement.enums.AttributeType;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class AttributeValue {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Attribute attribute;

    private AttributeType type;

    @ManyToOne(fetch=FetchType.LAZY)
    private Ticket ticket;

    private String string;

    private Float aFloat;

    private Boolean bool;

    private Date date;


}
