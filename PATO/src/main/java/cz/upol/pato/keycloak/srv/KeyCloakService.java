package cz.upol.pato.keycloak.srv;

import cz.upol.pato.keycloak.config.KeycloakAdminClientConfig;
import cz.upol.pato.keycloak.config.KeycloakAdminClientUtils;
import cz.upol.pato.keycloak.config.KeycloakPropertyReader;
import cz.upol.pato.mapstruct.dtos.UserPostDto;
import cz.upol.pato.usermanagement.ctrl.UserManagementController;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Arrays;

@Service
public class KeyCloakService {

    private static final Logger log = LoggerFactory.getLogger(KeyCloakService.class);

    @Autowired
    KeycloakPropertyReader keycloakPropertyReader;


    public String getCurrentUserEmail(){
        @SuppressWarnings("unchecked")
        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        String email = principal.getKeycloakSecurityContext().getToken().getEmail();
        return email;
    }

    public void createUser(UserPostDto newUserDto){
        UserRepresentation newUser = userDtoToUserRepresentation(newUserDto);

        @SuppressWarnings("unchecked")
        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        KeycloakAdminClientConfig keycloakAdminClientConfig = KeycloakAdminClientUtils.loadConfig(keycloakPropertyReader);
        Keycloak keycloak = KeycloakAdminClientUtils.getKeycloakClient(principal.getKeycloakSecurityContext(),keycloakAdminClientConfig);
        RealmResource realmResource = keycloak.realm(keycloakAdminClientConfig.getRealm());
        UsersResource userRessource = realmResource.users();
        newUser.setEnabled(true);
        Response response = userRessource.create(newUser);
        log.info(String.valueOf(response.getStatus()));
        log.info(String.valueOf(response.getStatusInfo()));
        log.info(String.valueOf(response.getStringHeaders()));
        response.close();
    }

    private UserRepresentation userDtoToUserRepresentation(UserPostDto newUserDto){
        UserRepresentation result = new UserRepresentation();

        CredentialRepresentation password = new CredentialRepresentation();
        password.setValue(newUserDto.getPassword());
        password.setType(CredentialRepresentation.PASSWORD);
        result.setCredentials(Arrays.asList(password));

        result.setEmail(newUserDto.getEmail());
        result.setFirstName(newUserDto.getFirstname());
        result.setLastName(newUserDto.getLastname());

        return result;
    }
}
