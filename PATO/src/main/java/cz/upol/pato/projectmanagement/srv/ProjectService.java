package cz.upol.pato.projectmanagement.srv;

import cz.upol.pato.mapstruct.dtos.ProjectPostDto;
import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.projectmanagement.repository.ProjectRepository;
import cz.upol.pato.usermanagement.entity.UserEntity;
import cz.upol.pato.usermanagement.srv.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserService userService;


    public List<Project> getProjectsForUser(long userId){
        UserEntity user = userService.getUserById(userId);
        return user.getProjects();
    }

    public List<Project> getProjectsForCurrentUser(){
        UserEntity user = userService.getCurrentUser();
        //todo try-catch
        List<Project> projects = user.getProjects();
        if (projects==null || projects.isEmpty()){
            return new ArrayList<>();
        }else {
            return projects;
        }
    }

    public Project getProjectById(long projectId){
        return projectRepository.getById(projectId);
    }

    public void changeDeadline(long id, Date date){
        Project project = projectRepository.getById(id);
        project.setDeadline(date);
        projectRepository.save(project);
    }

    public void createProject (ProjectPostDto dto){
        Project project  = new Project();
        project.setName(dto.getName());
        project.setShortcut(dto.getShortcut());
        project.setDeadline(dto.getDeadline());
        project.setActive(false);
        project.setCreateDate(new Date());
        project.setCreateUserName(userService.getCurrentUser().getName());
        project.setUsers(Collections.singletonList(userService.getCurrentUser()));
        projectRepository.save(project);
    }

    public void addUserToProject(Long projectId, String email){
        UserEntity user = userService.getUserByEmail(email);
        Project project = projectRepository.getById(projectId);
        project.getUsers().add(user);
        projectRepository.save(project);
    }

    public void deleteProject(Long projectId){
        projectRepository.deleteById(projectId);
    }

}
