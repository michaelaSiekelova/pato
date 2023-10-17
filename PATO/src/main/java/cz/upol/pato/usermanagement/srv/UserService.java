package cz.upol.pato.usermanagement.srv;

import cz.upol.pato.keycloak.srv.KeyCloakService;
import cz.upol.pato.mapstruct.dtos.UserPostDto;
import cz.upol.pato.projectmanagement.entity.Project;
import cz.upol.pato.projectmanagement.srv.ProjectService;
import cz.upol.pato.usermanagement.entity.UserEntity;
import cz.upol.pato.usermanagement.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final String ID = "50cb3dfb-8e0f-414b-9a37-2370b0dd8c14";
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    private KeyCloakService keyCloakService;


    public UserEntity getUserByEmail(String email){
        return repository
                .findByEmail(email);
    }

    public UserEntity getUserById(long id){
        return repository
                .findById(id);
    }

    public void createUser(UserPostDto newUser) {
        try {
            keyCloakService.createUser(newUser);
            String userId = keyCloakService.getUserId(newUser.getEmail());
            if (userId!=null){
                newUser.setKeycloakId(userId);
                createUserEntity(newUser);
            }
        }catch (IOException e ){
            log.error(e.getMessage(), e.getStackTrace());
        }
    }

    private void createUserEntity(UserPostDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDto.getEmail());
        userEntity.setName(userDto.getName());
        userEntity.setKeycloakId(userDto.getKeycloakId());
        userEntity.setActive(true);
        repository.save(userEntity);
    }

    public UserEntity getCurrentUser(){
        String keycloakId = keyCloakService.getCurrentUserId();
        return repository.findByKeycloakId(keycloakId);
    }

    public List<UserEntity> getUserCollegesForCurrentUser(){
        return repository.findAllByActiveIsTrue();
    }

    public List<UserEntity> getUsersNotInProject(List<Long> users){
        return repository.findAllByActiveIsTrueAndIdIsNotIn(users);
    }

    public List<UserEntity> getAllActiveUsers(){
        return repository.findAllByActiveIsTrue();
    }


    public boolean exists(){
        return repository.existsByKeycloakId(ID);
    }

    public void createAdmin(){
        UserEntity user = new UserEntity();
        user.setActive(false);
        user.setName("admin");
        user.setEmail("admin");
        user.setKeycloakId(ID);
        repository.save(user);
    }

}
