package cz.upol.pato.keycloak.srv;

import cz.upol.pato.keycloak.config.KeycloakAdminClientConfig;
import cz.upol.pato.keycloak.config.KeycloakAdminClientUtils;
import cz.upol.pato.mapstruct.dtos.UserPostDto;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class KeyCloakService {

    private static final Logger log = LoggerFactory.getLogger(KeyCloakService.class);
    @Autowired
    private KeycloakAdminClientConfig keycloakAdminClientConfig;



    public String getCurrentUserId(){
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        log.info(auth.getName());
        log.info(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        @SuppressWarnings("unchecked")
        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return principal.getName();
    }


    public void createUser(UserPostDto newUserDto) throws IOException {
        URL obj = new URL(getCreateUserUrl());
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        String token = getBearerToken();
        con.setRequestProperty("Authorization", "Bearer " + token);
        log.info("mam token "+ token);
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



    private String getCreateUserUrl(){
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
