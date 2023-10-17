package cz.upol.pato.ticketmanagement.srv;

import cz.upol.pato.mapstruct.dtos.TaskDto;
import cz.upol.pato.mapstruct.dtos.TicketPostDto;
import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.projectmanagement.repository.ProjectRepository;
import cz.upol.pato.ticketmanagement.entity.Task;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import cz.upol.pato.ticketmanagement.enums.TicketEnums;
import cz.upol.pato.ticketmanagement.repository.TaskRepository;
import cz.upol.pato.ticketmanagement.repository.TicketRepository;
import cz.upol.pato.usermanagement.entity.UserEntity;
import cz.upol.pato.usermanagement.srv.UserService;
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
    private TaskRepository taskRepository;

    public List<Ticket> getTicketsByCurrentUser(){
        UserEntity user = userService.getCurrentUser();
        //todo try-catch
        return user.getTickets();
    }

    public List<Ticket> getTicketsByUser(String email){
        UserEntity user = userService.getUserByEmail(email);
        //todo try-catch
        return user.getTickets();
    }

    public void updateTicketDescription(TicketPostDto ticket){
        Ticket ticketToUpdate = ticketRepository.getById(ticket.getId());
        ticketToUpdate.setDescription(ticket.getDescription());
        ticketRepository.save(ticketToUpdate);
    }

    public List<Ticket> getTicketsByProject(long projectId){
        Project project = projectRepository.findById(projectId);
        return project.getTickets();
    }

    public void createTicket(TicketPostDto ticketDto){
        Project project = projectRepository.findById(ticketDto.getProjectId());
        Ticket ticket = new Ticket();
        int numForKey = project.getTicketsCount()+1;
        project.setTicketsCount(project.getTicketsCount()+1);
        projectRepository.save(project);
        ticket.setKey(project.getShortcut() + "-" + numForKey);
        ticket.setName(ticketDto.getName());
        ticket.setProject(project);
        ticket.setDescription(ticketDto.getDescription());
        ticket.setCreateDate(new Date());
        ticket.setCreateUser(userService.getCurrentUser());
        ticket.setCurrentUser(userService.getCurrentUser());
        ticket.setDeadline(ticketDto.getDeadline());
        ticket.setType(TicketEnums.TicketType.valueOf(ticketDto.getType()));
        ticketRepository.save(ticket);
        //workflowService.createFirstWorkflowStateForTicket(ticket);
    }

    public Ticket getTicketById(Long id){
        return ticketRepository.getById(id);
    }

    public Project getProjectByTicket(Long id){
        Ticket ticket = ticketRepository.getById(id);
        return ticket!=null? ticket.getProject() : null;
    }

    public void setCurrentUser(Long ticketId, String userEmail){
        Ticket ticket = ticketRepository.getById(ticketId);
        UserEntity user = userService.getUserByEmail(userEmail);
        ticket.setCurrentUser(user);
        ticketRepository.save(ticket);
    }

    //todo createTaskForTicket
    //todo deleteTaskForTicket
    //todo getTicketTasks

    public List<Task> getTicketTasks(long ticketId){
        Ticket ticket = ticketRepository.getById(ticketId);
        return taskRepository.findByTicket(ticket);
    }

    public void createTicketTask(TaskDto taskDto){
        Ticket ticket = ticketRepository.getById(taskDto.getTicketId());
        Task task = new Task();
        task.setDescription(taskDto.getDescription());
        task.setDone(false);
        task.setTicket(ticket);
        taskRepository.save(task);
        reevaluateTicketProgress(ticket);

    }

    public void changeCheckTask(TaskDto taskDto){
        Ticket ticket = ticketRepository.getById(taskDto.getTicketId());
        Task task = taskRepository.getById(taskDto.getId());
        task.setDone(taskDto.isDone());
        taskRepository.save(task);
        reevaluateTicketProgress(ticket);
    }

    public void deleteTask(TaskDto taskDto){
        Long ticketId = taskDto.getTicketId();
        taskRepository.deleteById(taskDto.getId());
        Ticket ticket = ticketRepository.getById(ticketId);
        reevaluateTicketProgress(ticket);
    }

    private void reevaluateTicketProgress(Ticket ticket){
        List<Task>  tasks = taskRepository.findByTicket(ticket);
        int allTasks = tasks.size();
        int doneTasks = 0;
        for (Task task : tasks){
            if (task.isDone()){
                doneTasks++;
            }
        }
        if (allTasks>0) {
            ticket.setProgress((100 / allTasks) * doneTasks);
        }else {
            ticket.setProgress(100);
        }
        ticketRepository.save(ticket);
    }

    public void changeStartDate(long ticketId, Date date){
        Ticket ticket = ticketRepository.getById(ticketId);
        ticket.setStartDate(date);
        ticketRepository.save(ticket);
    }

    public void changeDeadline(long ticketId, Date date){
        Ticket ticket = ticketRepository.getById(ticketId);
        ticket.setDeadline(date);
        ticketRepository.save(ticket);
    }

    public void changeEndDate(long ticketId, Date date){
        Ticket ticket = ticketRepository.getById(ticketId);
        ticket.setEndDate(date);
        ticketRepository.save(ticket);
    }

    public void deleteTicket(Long ticketId){
        ticketRepository.deleteById(ticketId);
    }

}
