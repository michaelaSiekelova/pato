package cz.upol.pato.workflowmanagement.srv;

import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.projectmanagement.srv.ProjectService;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import cz.upol.pato.ticketmanagement.repository.TicketRepository;
import cz.upol.pato.workflowmanagement.entity.TicketWorkflowState;
import cz.upol.pato.workflowmanagement.entity.WorkflowState;
import cz.upol.pato.workflowmanagement.repository.TicketWorkflowStateRepository;
import cz.upol.pato.workflowmanagement.repository.WorkflowRepository;
import cz.upol.pato.workflowmanagement.repository.WorkflowStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowService {

    @Autowired
    private WorkflowRepository workflowRepository;

    @Autowired
    private TicketWorkflowStateRepository ticketWorkflowStateRepository;

    @Autowired
    private WorkflowStateRepository workflowStateRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ProjectService projectService;

    public void createFirstWorkflowStateForTicket(Ticket ticket){
        Project project = ticket.getProject();
        TicketWorkflowState result = new TicketWorkflowState();
        result.setState(project.getWorkflow().getFirstState());
        result.setTicket(ticket);
        ticketWorkflowStateRepository.save(result);
        ticket.setState(result);
        ticketRepository.save(ticket);
    }
}
