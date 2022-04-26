package cz.upol.pato.projectmanagement.entity;

import cz.upol.pato.attributesmanagement.entity.Attribute;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import cz.upol.pato.usermanagement.entity.UserEntity;
import cz.upol.pato.workflowmanagement.entity.Workflow;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Project {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String shortcut;

    private boolean active;

    @OneToMany(mappedBy="project", fetch=FetchType.LAZY)
    private List<Ticket> tickets;

    @OneToOne
    private Workflow workflow;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "projects_users",
            joinColumns = {
                    @JoinColumn(name = "project_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<UserEntity> users;

    @OneToMany(mappedBy="project")
    private List<Attribute> attributes;


}
