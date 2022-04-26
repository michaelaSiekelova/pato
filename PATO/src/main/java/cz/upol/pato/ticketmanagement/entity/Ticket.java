package cz.upol.pato.ticketmanagement.entity;

import cz.upol.pato.attachementsmanagement.entity.Attachement;
import cz.upol.pato.attributesmanagement.entity.AttributeValue;
import cz.upol.pato.commentsmanagement.entity.Comment;
import cz.upol.pato.historymanagement.entity.Event;
import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.usermanagement.entity.UserEntity;
import cz.upol.pato.workflowmanagement.entity.TicketWorkflowState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Ticket {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    @ManyToOne(fetch=FetchType.LAZY)
    private Project project;

    private Date createDate;

    @OneToMany(mappedBy="ticket")
    private List<Comment> comments;

    @OneToMany(mappedBy="ticket")
    private List<Attachement> attachements;

    @ManyToOne(fetch=FetchType.LAZY)
    private UserEntity currentUser;

    @ManyToOne(fetch=FetchType.LAZY)
    private UserEntity createUser;

    @OneToMany(mappedBy="ticket")
    private List<Event> history;

    @OneToOne
    private TicketWorkflowState state;

    @OneToMany(mappedBy="ticket")
    private List<AttributeValue> attributeValues;

}
