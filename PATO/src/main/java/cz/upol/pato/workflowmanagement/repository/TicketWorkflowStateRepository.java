package cz.upol.pato.workflowmanagement.repository;

import cz.upol.pato.workflowmanagement.entity.TicketWorkflowState;
import cz.upol.pato.workflowmanagement.entity.WorkflowState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketWorkflowStateRepository extends JpaRepository<TicketWorkflowState, Long>  {
}
