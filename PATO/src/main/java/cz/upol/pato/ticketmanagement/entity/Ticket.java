package cz.upol.pato.ticketmanagement.entity;

import cz.upol.pato.attributesmanagement.entity.AttributeValue;
import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.ticketmanagement.enums.TicketEnums;
import cz.upol.pato.usermanagement.entity.UserEntity;
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

    private String key;
    @Column(columnDefinition="TEXT")
    private String description;

    @ManyToOne(fetch=FetchType.LAZY)
    private Project project;
    @OneToMany(mappedBy="ticket", cascade = CascadeType.REMOVE)
    private List<Task> tasks;

    private Date createDate;

    private Date deadline;

    private Date startDate;

    private Date endDate;

    private Integer progress;


    @ManyToOne(fetch=FetchType.LAZY)
    private UserEntity currentUser;

    @ManyToOne(fetch=FetchType.LAZY)
    private UserEntity createUser;

    @OneToMany(mappedBy="ticket", cascade = CascadeType.REMOVE)
    private List<AttributeValue> attributeValues;

    private TicketEnums.TicketType type;

}
