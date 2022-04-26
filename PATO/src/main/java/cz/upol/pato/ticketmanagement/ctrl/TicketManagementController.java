package cz.upol.pato.ticketmanagement.ctrl;

import cz.upol.pato.mapstruct.dtos.TicketGetLightDto;
import cz.upol.pato.mapstruct.dtos.TicketPostDto;
import cz.upol.pato.mapstruct.mappers.MapStructMapper;
import cz.upol.pato.ticketmanagement.entity.Ticket;
import cz.upol.pato.ticketmanagement.srv.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/ticketManagement")
public class TicketManagementController {

    private static final Logger log = LoggerFactory.getLogger(TicketManagementController.class);

    @Autowired
    private MapStructMapper mapstructMapper;

    @Autowired
    private TicketService ticketService;

    @GetMapping(path = "user/ticketsForUser")
    public List<TicketGetLightDto> getTicketsForUser(){
        List<TicketGetLightDto> resultlist = new ArrayList<>();
        List<Ticket> entityList = ticketService.getTicketsByCurrentUser(1L);
        for (Ticket ticket:entityList
             ) {
            resultlist.add(mapstructMapper.ticketToTicketGetLightDto(ticket));
        }
        return resultlist;
    }

    @GetMapping(path = "user/ticketsForProject")
    public List<TicketGetLightDto> getTicketsForProject(@RequestParam(name="projectId") long projectId){
        List<TicketGetLightDto> resultlist = new ArrayList<>();
        List<Ticket> entityList = ticketService.getTicketsByProject(projectId);
        for (Ticket ticket:entityList
        ) {
            resultlist.add(mapstructMapper.ticketToTicketGetLightDto(ticket));
        }
        return resultlist;
    }

    @PostMapping
    public void createTicket(@RequestParam(name="name") String name, @RequestParam(name="description") String description,
                             @RequestParam(name="projectId") long projectId){
        TicketPostDto dto = new TicketPostDto(name, projectId, description);

    }
    
}
