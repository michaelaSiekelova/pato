package cz.upol.pato.projectmanagement.ctrl;

import cz.upol.pato.mapstruct.dtos.*;
import cz.upol.pato.mapstruct.mappers.MapStructMapper;
import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.projectmanagement.srv.ProjectService;
import cz.upol.pato.ticketmanagement.ctrl.TicketManagementController;
import cz.upol.pato.ticketmanagement.enums.TicketEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/projectManagement")
public class ProjectController {
    private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private MapStructMapper mapstructMapper;
    @Autowired
    private ProjectService projectService;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "project/create")
    public void createProject(@RequestBody ProjectPostDto dto){
        projectService.createProject(dto);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "project/projectIdsByCurrentUser")
    public List<ProjectGetLightDto> getProjectIdsByCurrentUser(){
        List<Project> projectList = projectService.getProjectsForCurrentUser();
        List<ProjectGetLightDto> projectGetLightDtos = new ArrayList<>();
        for(Project p: projectList){
            projectGetLightDtos.add(mapstructMapper.projectToProjectLightDto(p));
        }
        return projectGetLightDtos;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "project/projectsByCurrentUser")
    public List<ProjectDto> getProjectsByCurrentUser(){
        List<Project> projectList = projectService.getProjectsForCurrentUser();
        List<ProjectDto> projectDtos = new ArrayList<>();
        for(Project p: projectList){
            projectDtos.add(mapstructMapper.projectToProjectDto(p));
        }
        return projectDtos;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "project/projectsForSelect")
    public List<ProjectForSelectDto> getProjectsForSelect(){
        List<Project> projectList = projectService.getProjectsForCurrentUser();
        List<ProjectForSelectDto> projectDtos = new ArrayList<>();
        for(Project p: projectList){
            projectDtos.add(mapstructMapper.projectToProjectForSelectDto(p));
        }
        return projectDtos;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "project/projectById")
    public ProjectDto getProjectById(@RequestBody Long projectId){
        Project project = projectService.getProjectById(projectId);
        return mapstructMapper.projectToProjectDto(project);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "project/deadline")
    public void changeDeadline(@RequestBody DateModel model){
        projectService.changeDeadline(model.getId(), model.getDate());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "project/delete")
    public void deleteProject(@RequestBody Long projectId){
        projectService.deleteProject(projectId);
    }


}
