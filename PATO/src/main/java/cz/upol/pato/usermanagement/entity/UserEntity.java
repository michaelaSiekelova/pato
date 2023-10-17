package cz.upol.pato.usermanagement.entity;

import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private long id;

    @Basic
    private String keycloakId;

    @Basic
    private String name;

    @Basic
    private String email;


    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Project> projects;

    //Tickets where this user is current user
    @OneToMany(mappedBy="currentUser", fetch=FetchType.LAZY)
    private List<Ticket> tickets;

    @OneToMany(mappedBy="createUser", fetch=FetchType.LAZY)
    private List<Ticket> createdTickets;

    @Basic
    private boolean active;

}
