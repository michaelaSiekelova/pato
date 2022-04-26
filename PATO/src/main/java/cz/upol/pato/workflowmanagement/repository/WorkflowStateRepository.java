package cz.upol.pato.workflowmanagement.repository;

import cz.upol.pato.ticketmanagement.entity.Ticket;
import cz.upol.pato.workflowmanagement.entity.Workflow;
import cz.upol.pato.workflowmanagement.entity.WorkflowState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowStateRepository extends JpaRepository<WorkflowState, Long> {
}
