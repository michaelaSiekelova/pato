package cz.upol.pato.ticketmanagement.srv;

import cz.upol.pato.mapstruct.dtos.TicketPostDto;
import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.projectmanagement.repository.ProjectRepository;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import cz.upol.pato.ticketmanagement.repository.TicketRepository;
import cz.upol.pato.usermanagement.entity.UserEntity;
import cz.upol.pato.usermanagement.repository.UserRepository;
import cz.upol.pato.usermanagement.srv.UserService;
import cz.upol.pato.workflowmanagement.srv.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private WorkflowService workflowService;

    public List<Ticket> getTicketsByCurrentUser(){
        UserEntity user = userService.getCurrentUser();
        return user.getTickets();
    }

    public List<Ticket> getTicketsByProject(long projectId){
        Project project = projectRepository.findById(projectId);
        return project.getTickets();
    }

    public void createTicket(TicketPostDto ticketDto){
        Project project = projectRepository.findById(ticketDto.getProjectId());
        Ticket ticket = new Ticket();
        ticket.setName(project.getShortcut() + " - " + ticketDto.getName());
        ticket.setProject(project);
        ticket.setDescription(ticketDto.getDescription());
        ticket.setCreateDate(new Date());
        ticket.setCreateUser(userService.getCurrentUser());
        ticket.setCurrentUser(userService.getCurrentUser());
        ticketRepository.save(ticket);
        workflowService.createFirstWorkflowStateForTicket(ticket);
    }

}
