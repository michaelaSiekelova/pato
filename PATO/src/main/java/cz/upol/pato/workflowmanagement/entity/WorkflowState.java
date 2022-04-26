package cz.upol.pato.workflowmanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class WorkflowState {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy="state")
    private List<TicketWorkflowState> ticketStates;

    @ManyToMany(mappedBy="nextStates")
    private List<WorkflowState> previousState;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "workflow_states",
            joinColumns = {
                    @JoinColumn(name = "from_state", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "to_state", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<WorkflowState> nextStates;

    @ManyToOne(fetch=FetchType.LAZY)
    private Workflow workflow;
}
