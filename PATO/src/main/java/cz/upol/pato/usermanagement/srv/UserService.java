package cz.upol.pato.usermanagement.srv;

import cz.upol.pato.keycloak.srv.KeyCloakService;
import cz.upol.pato.mapstruct.dtos.UserPostDto;
import cz.upol.pato.usermanagement.entity.UserEntity;
import cz.upol.pato.usermanagement.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.core.Response;
import java.io.IOException;

@Service
public class UserService {
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

    public void createUser(String email,String password,String firstname,String lastname) {
        UserPostDto newUser = new UserPostDto(firstname, lastname, email, password, null);
        try {
            keyCloakService.createUser(newUser);
            String userId = keyCloakService.getUserId(email);
            if (userId!=null){
                newUser.setKeycloakId(userId);
                createUserEntity(newUser);
            }
        }catch (IOException e ){
            log.error(e.getMessage());
        }
    }

    private void createUserEntity(UserPostDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDto.getEmail());
        userEntity.setFirstname(userDto.getFirstname());
        userEntity.setLastname(userDto.getLastname());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setKeycloakId(userDto.getKeycloakId());
        repository.save(userEntity);
    }

    public UserEntity getCurrentUser(){
        String keycloakId = keyCloakService.getCurrentUserId();
        log.info("Current User keycloak Id: " + keycloakId);
        return repository.findByKeycloakId(keycloakId);
    }

}
