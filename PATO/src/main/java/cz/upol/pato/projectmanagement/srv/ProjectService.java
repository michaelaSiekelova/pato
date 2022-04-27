package cz.upol.pato.projectmanagement.srv;

import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.projectmanagement.repository.ProjectRepository;
import cz.upol.pato.usermanagement.entity.UserEntity;
import cz.upol.pato.usermanagement.srv.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        List<Project> projects = user.getProjects();
        if (projects==null || projects.isEmpty()){
            return new ArrayList<>();
        }else {
            return projects;
        }
    }

    public Project getProjectById(long projectId){
        return projectRepository.findById(projectId);
    }

    public void createProject (String name, String shortcut){
        Project project  = new Project();
        project.setName(name);
        project.setShortcut(shortcut);
        project.setActive(false);
        project.setUsers(Collections.singletonList(userService.getCurrentUser()));
        projectRepository.save(project);
    }

}
