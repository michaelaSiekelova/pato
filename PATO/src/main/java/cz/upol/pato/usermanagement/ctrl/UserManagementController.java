package cz.upol.pato.usermanagement.ctrl;

import cz.upol.pato.keycloak.config.KeycloakAdminClientUtils;
import cz.upol.pato.keycloak.srv.KeyCloakService;
import cz.upol.pato.mapstruct.dtos.TicketPostDto;
import cz.upol.pato.mapstruct.dtos.UserGetDto;
import cz.upol.pato.mapstruct.dtos.UserPostDto;
import cz.upol.pato.mapstruct.mappers.MapStructMapper;
import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.projectmanagement.srv.ProjectService;
import cz.upol.pato.ticketmanagement.srv.TicketService;
import cz.upol.pato.usermanagement.entity.UserEntity;
import cz.upol.pato.usermanagement.srv.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/userManagement")
public class UserManagementController {

    private static final Logger log = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private MapStructMapper mapstructMapper;


    @CrossOrigin(origins = "*")
    @GetMapping(path = "user/email")
    public UserGetDto getUserByEmail(@RequestParam(name="email") String email){
        return mapstructMapper.userToUserGetDto(userService.getUserByEmail(email));
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "user/userById")
    public UserGetDto getUserById(@RequestBody Long id){
        return mapstructMapper.userToUserGetDto(userService.getUserById(id));
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "user/getCurrentUser")
    public UserGetDto getCurrentUser(){
        UserGetDto dto = mapstructMapper.userToUserGetDto(userService.getCurrentUser());
        return dto;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/user/allUserColleges")
    public List<UserGetDto> getUserColleges(){
        List<UserGetDto> resultList = new ArrayList<>();
        List<UserEntity> users = userService.getUserCollegesForCurrentUser();
        for (UserEntity user : users){
            resultList.add(mapstructMapper.userToUserGetDto(user));
        }
        return resultList;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/user/allUsersForProject")
    public List<UserGetDto> getUsersForProject(@RequestBody Long projectId){
        List<UserGetDto> resultList = new ArrayList<>();
        Project project = projectService.getProjectById(projectId);
        if (project!=null){
            List<UserEntity> users = project.getUsers();
            for (UserEntity user : users){
                resultList.add(mapstructMapper.userToUserGetDto(user));
            }
        }
        return resultList;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "user/create")
    public void createUser(@RequestBody UserPostDto user){
        log.info("calling createUser");

        userService.createUser(user);
    }

    //Methods for choosing user for project or ticket
    @CrossOrigin(origins = "*")
    @PostMapping(path = "user/forTicket")
    public List<UserGetDto> getUsersForTicketToChoose(@RequestBody Long ticketId){
        log.info("calling getUsersForTicketToChoose");
        List<UserGetDto> resultList = new ArrayList<>();
        Project project = ticketService.getProjectByTicket(ticketId);
        if (project!=null){
            List<UserEntity> users = project.getUsers();
            for (UserEntity user : users){
                resultList.add(mapstructMapper.userToUserGetDto(user));
            }
        }
        return resultList;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "user/forProject")
    public List<UserGetDto> getUsersForProjectToChoose(@RequestBody Long projectId){
        log.info("calling getUsersForProjectToChoose");
        List<UserGetDto> resultList = new ArrayList<>();
        Project project = projectService.getProjectById(projectId);
        List<UserEntity> usersInProject = project.getUsers();
        List<UserEntity> usersAll = userService.getAllActiveUsers();
        for (UserEntity user : usersAll){
            if (!usersInProject.contains(user)) {
                resultList.add(mapstructMapper.userToUserGetDto(user));
            }
        }
        return resultList;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "user/choosenForTicket")
    public void addUserForTicket(@RequestBody UserPostDto user){
        log.info("calling addUserForTicket");
        ticketService.setCurrentUser(user.getTicketId(), user.getEmail());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "user/choosenForProject")
    public void addUserForProject(@RequestBody UserPostDto user){
        log.info("calling addUserForProject");
        projectService.addUserToProject(user.getProjectId(), user.getEmail());
    }

    @GetMapping(path = "user/test")
    public void test(){
        log.info("calling test");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createAdminIfNotExists() {
        if (!userService.exists()){
            userService.createAdmin();
        }
    }

}
