package cz.upol.pato.workflowmanagement.repository;

import cz.upol.pato.ticketmanagement.entity.Ticket;
import cz.upol.pato.workflowmanagement.entity.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowRepository extends JpaRepository<Workflow, Long> {
}
