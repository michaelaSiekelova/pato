package cz.upol.pato.ticketmanagement.ctrl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import cz.upol.pato.mapstruct.dtos.DateModel;
import cz.upol.pato.mapstruct.dtos.TaskDto;
import cz.upol.pato.mapstruct.dtos.TicketGetLightDto;
import cz.upol.pato.mapstruct.dtos.TicketPostDto;
import cz.upol.pato.mapstruct.mappers.MapStructMapper;
import cz.upol.pato.ticketmanagement.entity.Task;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import cz.upol.pato.ticketmanagement.enums.TicketEnums;
import cz.upol.pato.ticketmanagement.srv.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/ticketManagement")
public class TicketManagementController {

    private static final Logger log = LoggerFactory.getLogger(TicketManagementController.class);

    @Autowired
    private MapStructMapper mapstructMapper;

    @Autowired
    private TicketService ticketService;

    @CrossOrigin(origins = "*")
    @GetMapping(path = "ticket/ticketsForUser")
    public List<TicketGetLightDto> getTicketsForUser(){
        List<TicketGetLightDto> resultlist = new ArrayList<>();
        List<Ticket> entityList = ticketService.getTicketsByCurrentUser();
        for (Ticket ticket:entityList
             ) {
            resultlist.add(mapstructMapper.ticketToTicketGetLightDto(ticket));
        }
        return resultlist;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "ticket/ticketsForUser")
    public List<TicketGetLightDto> getTicketsForUser(@RequestBody String userEmail){
        List<TicketGetLightDto> resultlist = new ArrayList<>();
        List<Ticket> entityList = ticketService.getTicketsByUser(userEmail);
        for (Ticket ticket:entityList
        ) {
            resultlist.add(mapstructMapper.ticketToTicketGetLightDto(ticket));
        }
        return resultlist;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "ticket/updateTicketDescription")
    public void updateTicketDescription(@RequestBody TicketPostDto ticket){
        ticketService.updateTicketDescription(ticket);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "ticket/ticketsForProject")
    public List<TicketGetLightDto> getTicketsForProject(@RequestBody Long projectId){
        List<TicketGetLightDto> resultlist = new ArrayList<>();
        List<Ticket> entityList = ticketService.getTicketsByProject(projectId);
        for (Ticket ticket:entityList
        ) {
            TicketGetLightDto dto = mapstructMapper.ticketToTicketGetLightDto(ticket);
            if(dto.getStartDate()!=null && dto.getEndDate()!=null) {
                dto.setDuration(Duration.between(dto.getStartDate().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate().atStartOfDay(), dto.getEndDate().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate().atStartOfDay()).toDays());
            }
            resultlist.add(dto);
        }
        return resultlist;
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "ticket/ticketTypes")
    public List<TicketEnums.TicketType> getTicketTypes(){
        return TicketEnums.getTicketTypes();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "ticket/create")
    public void createTicket(@RequestBody TicketPostDto ticket){
        if (ticket!=null){
            ticketService.createTicket(ticket);
        }
        new ResponseEntity<>("User Created Successfully", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "ticket/delete")
    public void deleteTicket(@RequestBody Long ticketId){
        if (ticketId!=null){
            ticketService.deleteTicket(ticketId);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "ticket/ticketById")
    public TicketGetLightDto getTicketById(@RequestBody Long id){
        Ticket ticket = ticketService.getTicketById(id);
        return mapstructMapper.ticketToTicketGetLightDto(ticket);
    }

    //todo createTaskForTicket
    //todo deleteTaskForTicket
    //todo getTicketTasks

    @CrossOrigin(origins = "*")
    @PostMapping(path = "task/create")
    public void createTicketTask(@RequestBody TaskDto taskDto){
        ticketService.createTicketTask(taskDto);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "task/delete")
    public void deleteTask(@RequestBody TaskDto taskDto){
        ticketService.deleteTask(taskDto);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "task/tasksForTicket")
    public List<TaskDto> getTasks(@RequestBody Long ticketId){
        List<TaskDto> resultList = new ArrayList<>();
        List<Task> tasks = ticketService.getTicketTasks(ticketId);
        for (Task task : tasks){
            resultList.add(mapstructMapper.taskToTaskDto( task));
        }
        return resultList;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "task/check")
    public void checkTask(@RequestBody TaskDto taskDto){
        ticketService.changeCheckTask(taskDto);
    }

   @CrossOrigin(origins = "*")
    @PostMapping(path = "ticket/deadline")
    public void changeDeadline(@RequestBody DateModel model){
        ticketService.changeDeadline(model.getId(), model.getDate());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "ticket/endDate")
    public void changeEndDate(@RequestBody DateModel model){
        ticketService.changeEndDate(model.getId(), model.getDate());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "ticket/startDate")
    public void changeStartDate(@RequestBody DateModel model){
        ticketService.changeStartDate(model.getId(), model.getDate());
    }

    private void printDate(Date date){
        String pattern = "MM/dd/yyyy HH:mm:ss";

        DateFormat df = new SimpleDateFormat(pattern);
;
        String todayAsString = df.format(date);

        log.info("using date " + todayAsString);
    }
    
}
