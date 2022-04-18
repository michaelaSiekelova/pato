package cz.upol.pato.usermanagement.ctrl;

import cz.upol.pato.keycloak.config.KeycloakAdminClientUtils;
import cz.upol.pato.keycloak.srv.KeyCloakService;
import cz.upol.pato.mapstruct.dtos.UserGetDto;
import cz.upol.pato.mapstruct.dtos.UserPostDto;
import cz.upol.pato.mapstruct.mappers.MapStructMapper;
import cz.upol.pato.usermanagement.srv.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("api/userManagement")
public class UserManagementController {

    private static final Logger log = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private MapStructMapper mapstructMapper;

    @Autowired
    private KeyCloakService keyCloakService;

    @GetMapping(path = "user/email/{email}")
    public UserGetDto getUserByEmail(String email){
        return mapstructMapper.userToUserGetDto(userService.getUserByEmail(email));
    }

    @PostMapping(path = "user/create")
    public void createUser(@RequestParam(name="email") String email, @RequestParam(name="password") String password,
                           @RequestParam(name="firstname") String firstname,@RequestParam(name="lastname")  String lastname){
        log.info("calling createUser");
        UserPostDto newUser = new UserPostDto(firstname, lastname, email, password);
        keyCloakService.createUser(newUser);
        userService.createUser(newUser);
    }

    @GetMapping(path = "user/test")
    public void test(){
        log.info("calling test");
    }

}
