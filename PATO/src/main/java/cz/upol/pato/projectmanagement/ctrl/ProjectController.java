package cz.upol.pato.projectmanagement.ctrl;

import cz.upol.pato.mapstruct.mappers.MapStructMapper;
import cz.upol.pato.projectmanagement.srv.ProjectService;
import cz.upol.pato.ticketmanagement.ctrl.TicketManagementController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/projectManagement")
public class ProjectController {
    private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private MapStructMapper mapstructMapper;
    @Autowired
    private ProjectService projectService;

    @PostMapping(path = "project/create")
    public void createProject(@RequestParam(name="name") String name, @RequestParam(name="shortcut") String shortcut){
        projectService.createProject(name, shortcut);
    }
}
