package cz.upol.pato.keycloak.srv;

import cz.upol.pato.keycloak.config.KeycloakAdminClientConfig;
import cz.upol.pato.keycloak.config.KeycloakAdminClientUtils;
import cz.upol.pato.keycloak.config.KeycloakPropertyReader;
import cz.upol.pato.mapstruct.dtos.UserPostDto;
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
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class KeyCloakService {

    private static final Logger log = LoggerFactory.getLogger(KeyCloakService.class);

    @Autowired
    KeycloakPropertyReader keycloakPropertyReader;


    public String getCurrentUserId(){
        @SuppressWarnings("unchecked")
        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return principal.getKeycloakSecurityContext().getToken().getId();
    }
/*
    public Response createUser(UserPostDto newUserDto){
        UserRepresentation newUser = userDtoToUserRepresentation(newUserDto);

        @SuppressWarnings("unchecked")
        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        KeycloakAdminClientConfig keycloakAdminClientConfig = KeycloakAdminClientUtils.loadConfig(keycloakPropertyReader);
        Keycloak keycloak = KeycloakAdminClientUtils.getKeycloakClient(principal.getKeycloakSecurityContext(),keycloakAdminClientConfig);
        RealmResource realmResource = keycloak.realm(keycloakAdminClientConfig.getRealm());
        UsersResource userRessource = realmResource.users();
        Response response = userRessource.create(newUser);
        log.info(String.valueOf(response.getStatus()));
        log.info(String.valueOf(response.getStatusInfo()));
        log.info(String.valueOf(response.getStringHeaders()));
        response.close();
        return response;
    }
 */

    public void createUser(UserPostDto newUserDto) throws IOException {
        URL obj = new URL(getCreateUserUrl());
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setRequestProperty("Authorization", "Bearer " + getBearerToken());

        con.setDoOutput(true);
        OutputStream outStream = con.getOutputStream();
        OutputStreamWriter outStreamWriter = new OutputStreamWriter(outStream, "UTF-8");
        outStreamWriter.write(newUserDto.createRequestBody());
        outStreamWriter.flush();
        outStreamWriter.close();
        outStream.close();

        System.out.println(con.getResponseCode());
        System.out.println(con.getResponseMessage());

    }
/*
    private UserRepresentation userDtoToUserRepresentation(UserPostDto newUserDto){
        UserRepresentation result = new UserRepresentation();

        CredentialRepresentation password = new CredentialRepresentation();
        password.setValue(newUserDto.getPassword());
        password.setTemporary(false);
        password.setType(CredentialRepresentation.PASSWORD);
        result.setCredentials(Arrays.asList(password));

        result.setEmail(newUserDto.getEmail());
        result.setFirstName(newUserDto.getFirstname());
        result.setLastName(newUserDto.getLastname());
        result.setEnabled(true);

        return result;
    }

 */

    private String getCreateUserUrl(){
        KeycloakAdminClientConfig keycloakAdminClientConfig = KeycloakAdminClientUtils.loadConfig(keycloakPropertyReader);
        return keycloakAdminClientConfig.getServerUrl()+
                "/admin/realms/"+
                keycloakAdminClientConfig.getRealm()+
                "/users";
    }


    private String getBearerToken(){
        @SuppressWarnings("unchecked")
        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return principal.getKeycloakSecurityContext().getTokenString();
    }

    public String getUserId(String email){
        @SuppressWarnings("unchecked")
        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        KeycloakAdminClientConfig keycloakAdminClientConfig = KeycloakAdminClientUtils.loadConfig(keycloakPropertyReader);
        Keycloak keycloak = KeycloakAdminClientUtils.getKeycloakClient(principal.getKeycloakSecurityContext(),keycloakAdminClientConfig);
        RealmResource realmResource = keycloak.realm(keycloakAdminClientConfig.getRealm());
        UsersResource userRessource = realmResource.users();
        List<UserRepresentation> users = userRessource.search(email);
        if (users == null || users.size() != 1){
            return null;
        }
        return users.get(0).getId();
    }
}
