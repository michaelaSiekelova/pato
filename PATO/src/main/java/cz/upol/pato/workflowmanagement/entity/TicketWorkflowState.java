package cz.upol.pato.workflowmanagement.entity;

import cz.upol.pato.ticketmanagement.entity.Ticket;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class TicketWorkflowState {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Ticket ticket;

    @OneToOne
    private TicketWorkflowState previous;

    @ManyToOne(fetch=FetchType.LAZY)
    private WorkflowState state;

}
