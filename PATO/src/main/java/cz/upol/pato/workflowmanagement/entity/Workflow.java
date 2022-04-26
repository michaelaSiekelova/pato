package cz.upol.pato.workflowmanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Workflow {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy="workflow")
    private List<WorkflowState> states;

    @OneToOne
    private WorkflowState firstState;
}
